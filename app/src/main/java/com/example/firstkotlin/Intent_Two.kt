package com.example.firstkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Intent_Two : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_two)

        //아래 intent는 Intent_Two.kt를 호출한 Activity
        val intent=intent
        val data:String?=intent.extras?.getString("extra-data")

        if(data!=null){
            Log.d("xxx","Intent_Two.kt ==> ${data.toString()}")
        }

    }
}