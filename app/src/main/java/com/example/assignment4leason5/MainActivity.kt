package com.example.assignment4leason5

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val REQUEST_RESULT = "REQUEST_RESULT"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var user1 = User("f", "f", "First", " User")
        var user2 = User("second@test.com", "second", "Second", " User")
        var user3 = User("third@test.com", "third", "Third", " User")
        var user4 = User("fourth@test.com", "fourth", "Fourth", " User")
        var user5 = User("fifth@test.com", "fifth", "Fifth", " User")
        var users: ArrayList<User> = ArrayList<User>()
        users.add(user1)
        users.add(user2)
        users.add(user3)
        users.add(user4)
        users.add(user5)

        login.setOnClickListener {

            var email = email.text.toString()
            var password = password.text.toString()

            if (email != null || email != "" || password != null || password != "") {
                for ((i, user) in users.withIndex()) {
                    if (user.emailAddress == email) {
                        if (user.passWord == password) {
                            var intent = Intent(this, ShoppingCategory::class.java)
                            intent.putExtra("username", "${user.firstName} ${user.lastName}")
                            startActivity(intent)
                        }
                    }
                    if (i == users.size) {
                        Toast.makeText(this, "Wrong Email or Password", Toast.LENGTH_LONG).show()
                    }
                }
            } else {
                Toast.makeText(this, "Please Enter Email and Password to Login", Toast.LENGTH_LONG)
                    .show()
            }
        }

        forgotPass.setOnClickListener {
            var email = email.text.toString()
            var pass : String = ""
            for (user in users) {
                if (user.emailAddress == email) {
                    pass = user.passWord
                    break
                }
            }
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:${email}?&subject=Forgot Password&body=$pass"))

            startActivity(intent)
        }

        var resultContracts =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

                if (result.resultCode == Activity.RESULT_OK) {
                    var newUser =
                        result.data?.getExtras()?.getSerializable("user") as User

                    users.add(newUser)

                    Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_LONG)
                } else {
                    Toast.makeText(this, "Failed to Create new Account", Toast.LENGTH_LONG)
                }
            }
        register.setOnClickListener {
            var intent = Intent(this, Register::class.java)
            resultContracts.launch(intent)
        }

    }
    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            Toast.makeText(
                this, Integer.toString(
                    data.getIntExtra(
                        REQUEST_RESULT,
                        0
                    )
                ), Toast.LENGTH_LONG
            ).show()
        }
    }*/


}