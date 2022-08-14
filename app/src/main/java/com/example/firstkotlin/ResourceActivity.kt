package com.example.firstkotlin

import android.content.res.Resources
import android.net.wifi.WifiConfiguration.AuthAlgorithm.strings
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class ResourceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        findViewById<TextView>(R.id.text).setOnClickListener{
            (it as TextView).text=resources.getText(R.string.app_name)
//            it.background=resources.getDrawable(R.drawable.arrows,null)
//            it.background= ContextCompat.getDrawable(this,R.drawable.khe_works1)
            it.background= ResourcesCompat.getDrawable(resources,R.drawable.khe_works1,null)
        }
    }
}