package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

//        Register.setOnClickListener{
//
//            val intent = Intent(this,SecondActivity::class.java)
//            startActivity(intent)
//        }
    }


}
