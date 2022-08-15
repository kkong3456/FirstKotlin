package com.example.firstkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)

        val imageView=findViewById<ImageView>(R.id.image)
        Glide
            .with(this)
            .load("https://imagescdn.gettyimagesbank.com/500/202005/jv12009213.jpg")
            .circleCrop()
            .into(imageView)
    }
}