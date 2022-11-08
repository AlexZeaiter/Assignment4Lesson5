package com.example.assignment4leason5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shopping_category.*

class ShoppingCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        val sintent = intent
        var userName = sintent.getStringExtra("username")

        var welcomeMessage = "Welcome $userName"

        username.text = welcomeMessage
    }

    fun click(view: View) {
        when (view.id) {
            R.id.electronics -> {
                Toast.makeText(this, "You have chosen Electronics", Toast.LENGTH_LONG).show()
            }
            R.id.clothes -> {
                Toast.makeText(this, "You have chosen Clothes", Toast.LENGTH_LONG).show()
            }
            R.id.makeup -> {
                Toast.makeText(this, "You have chosen Makeup", Toast.LENGTH_LONG).show()
            }
            R.id.food -> {
                Toast.makeText(this, "You have chosen Food", Toast.LENGTH_LONG).show()
            }
        }
    }
}