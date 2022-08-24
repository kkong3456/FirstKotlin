package com.example.firstkotlin

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SharedPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        findViewById<TextView>(R.id.create).setOnClickListener{
            val sharePreferences:SharedPreferences=getSharedPreferences("table_name", Context.MODE_PRIVATE)
            //MODE_PRIVATE : 다른앱과 공유하지 않겠다.
            //MODE_WORLD_READABLE,WRITEABLE : 다른 앱에서 읽기나,읽기/쓰기 가능
            //MODE_MULTI_PROCESS : 이미 호출되어 사용중인지 체크
            //MODE_APPEND : 기존 preference에 신규 추가

            val editor:SharedPreferences.Editor = sharePreferences.edit()
            editor.putString("key1","hello")
            editor.putString("key2","hello2")
            editor.commit()

        }
        findViewById<TextView>(R.id.read).setOnClickListener{
            val sharedPreferences:SharedPreferences=getSharedPreferences("table_name",Context.MODE_PRIVATE)
            val valueOne:String?=sharedPreferences.getString("key1","wrong1")
            val valueTwo:String?=sharedPreferences.getString("key2","wrong2")

            Log.d("xxx","valueOne is $valueOne")
            Log.d("xxx","valueTwo is $valueTwo")
        }

        findViewById<TextView>(R.id.update).setOnClickListener{
            val sharedPreferences:SharedPreferences=getSharedPreferences("table_name",Context.MODE_PRIVATE)
            val editor:SharedPreferences.Editor=sharedPreferences.edit()
            editor.putString("key1","hello hello1")
            editor.putString("key2","hello hello2")
            editor.commit()
        }

        findViewById<TextView>(R.id.delete).setOnClickListener {
            val sharedPreferences:SharedPreferences=getSharedPreferences("table_name",Context.MODE_PRIVATE)
            val editor:SharedPreferences.Editor=sharedPreferences.edit()
            editor.clear()
            editor.commit()
        }
    }
}