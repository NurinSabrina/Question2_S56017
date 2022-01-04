package com.example.question2_labtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnLog = findViewById<Button>(R.id.btnLogout)
        btnLog.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java).apply {

            }
            startActivity(intent)


        }
    }
}