package com.example.question2_labtest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(!dbExists(this,"mydata")){
            createDB();
        }

        val username = findViewById<EditText>(R.id.inUsername)
        val password = findViewById<EditText>(R.id.inPassword)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        btnSubmit.setOnClickListener(){
            val user = username.text;
            val pass = password.text;
            Toast.makeText(this@MainActivity, user, Toast.LENGTH_LONG).show()
            val intent = Intent(this, SecondActivity::class.java).apply {

            }
            startActivity(intent)


        }
    }

    private fun dbExists(c: Context, dbName: String):Boolean {
        val dbFile: File = c.getDatabasePath(dbName)
        return dbFile.exists()
    }

    private fun createDB(){
        val db = openOrCreateDatabase("mydata", MODE_PRIVATE,null)
        subToast("Database mydata created!")
        val sqlText = "CREATE TABLE IF NOT EXISTS user" +
                "(username VARCHAR(30) PRIMARY KEY,"+
                "password VARCHAR(30) NOT NULL" +
                ");"
        db.execSQL(sqlText)
        var nextSQL = "INSERT INTO user(username, password) VALUES ('ahmad','ahmad1234');"
        db.execSQL(nextSQL)
        subToast("Username and password added")
    }

    private fun subToast(msg: String){
        Toast.makeText( this,msg, Toast.LENGTH_SHORT).show()
    }

}