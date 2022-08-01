package com.example.firstkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Activity_01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_01)

        Log.d("LifeCycle","onCreate")
    }
    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycle","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle","onDestroy")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("LifeCycle","onRestart")
    }
}