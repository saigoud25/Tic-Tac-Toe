package com.example.tictoctoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val computer = findViewById<Button>(R.id.computer)
        val player2 = findViewById<Button>(R.id.player2)


    }

    fun select(view: View) {
        var selected = view as Button
        var Id = 0
        Log.d("buSelected", selected.id.toString())
        when(selected.id)
        {
            R.id.computer -> Id = 1
            R.id.player2 -> Id = 2
        }
        intent = Intent(this, MainActivity::class.java)
        intent.putExtra("value", Id)
        startActivity(intent)
    }
}