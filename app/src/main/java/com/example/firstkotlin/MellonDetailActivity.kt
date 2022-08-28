package com.example.firstkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MellonDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mellon_detail)

        val melonItemList=intent.getSerializableExtra("melon_item_list") as ArrayList<MelonItem>

        melonItemList.forEach{
            Log.d("xxx",it.title)
        }
    }
}