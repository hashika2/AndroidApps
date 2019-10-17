package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

            Register.setOnClickListener{
                if(editText.text.toString()=="hashika"){

                    if(editText2.text.toString()=="12345"){
                    val intent = Intent(this,ThirdActivity::class.java)
                    startActivity(intent)
                }
                    else{
                    editText2.error="Please Enter Correct username"
                    editText2.requestFocus()
                }

                }

                else{
                    editText.error="Please Enter Correct Password"
                    editText.requestFocus()
                }


        }
    }


}
