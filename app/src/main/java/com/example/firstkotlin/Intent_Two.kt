package com.example.firstkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

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

        (findViewById<TextView>(R.id.finish)).apply{
            this.setOnClickListener {
                val intent:Intent= Intent()
                intent.putExtra("result","데이터 전달 성공")
                setResult(RESULT_OK,intent)
                finish() //Intent_Two Activity 종료
            }
        }

    }
}