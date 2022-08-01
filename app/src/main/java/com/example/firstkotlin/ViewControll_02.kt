package com.example.firstkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class ViewControll_02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_controll02)


        val textViewOne: TextView =findViewById(R.id.textViewOne)
        val buttonOne : Button = findViewById(R.id.buttonOne)

        Log.d("testt",textViewOne.text.toString())

        //Listener 사용방법
        buttonOne.setOnClickListener {
            Log.d("testt","it.toString is "+it.toString())
            Log.d("testt","버튼 클릭!!")
        }
    }
}