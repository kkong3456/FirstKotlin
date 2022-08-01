package com.example.firstkotlin

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class Intent_One : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_one)

        //암시적 인텐트,. 전화,sms,google play store,website,googleMap, 사진첩 등등
        val implicity_indent: TextView =findViewById(R.id.implicit_indent)
        implicity_indent.setOnClickListener{
            //전화번호는 URI형식으로
            //URI는 URL보다 상위개념
            //Uniform resource Identifier, 고유하다
            val intent: Intent =Intent(
                Intent.ACTION_DIAL,   //ACTION_PICK 은 사진첩을 여는 인텐트 액션
                Uri.parse("tel:010-1111-2222")
            )
            startActivity(intent)
            Log.d("xxx","전화걸기")
        }

        //방법1(비추천, componentName hardcoding) : 명시적 인텐트 + ComponentName => 액티비티 전환
        // Intent_One.kt Activity에서 클릭으로 Intent_Two.kt Activity를 호출
        val intent_one:TextView=findViewById(R.id.intent_one)

        intent_one.setOnClickListener {
            val intent:Intent=Intent()
            Log.d("xxx","1 step")
            val componentName:ComponentName= ComponentName(
                "com.example.firstkotlin",
                "com.example.firstkotlin.Intent_Two"
            )
            intent.component=componentName
            startActivity(intent)
            Log.d("xxx","4 steps")
        }
        //방법2(추천) : 명시적 인텐트 -> 액티비티 전환
        // Context 문맥
        //액태비티A -> 액티비티B(Intent_One.kt => Intent_Two.kt)

        (findViewById<TextView>(R.id.intent_two)).apply{
            this.setOnClickListener{
                startActivity(
                    Intent(this@Intent_One,Intent_Two::class.java)
                //위 this는 더 작은 범위의 TextView를 의미함으로 this@Intent_One으로 명시적으로
                //this가 누군지 표시해주는 @ 코틀린 문법
                )
            }
        }
        //명시적 인텐트 + 데이터 전달
        (findViewById<TextView>(R.id.intent_three)).apply {
            this.setOnClickListener {
                var intent=Intent(this@Intent_One,Intent_Two::class.java)
                intent.putExtra("extra-data","data-one")
                startActivity(intent)
            }
        }
    }
}