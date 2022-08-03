package com.example.firstkotlin

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

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
        // 명시적 인텐트 + 결과 값 받기-1
        //Intent_One에서 요청하고 결과값 받고, Intent_Two에서 결과 값을 보낸다
        //requestCode 는 구분을 위함, Intent_One 이 Intent_Two 이외 다른 액티비티에도 보낼수 있기 때문에...
        (findViewById<TextView>(R.id.intent_four)).apply{
            this.setOnClickListener{
                var intent=Intent(this@Intent_One,Intent_Two::class.java)
                startActivityForResult(intent,1)
            }
        }

        //명시적 인텐트 + 결과값 받기-2 (ActivityResult API)
        //requestCode가 없으며, 요청자를 구분할수 있다.
        val startActivityLauncher :ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        )
        {
            //onActivityResult 부분
            when(it.resultCode){
                RESULT_OK->{
                    Log.d("xxx",it.data?.extras?.getString("result")!!)
                }
            }

            //onActivityResult 는
            //모든 intent가 한곳에서 처리된다. 구분이 필요하다
            //ActivityResult API는 intent가 처리되는 곳이 각각이다.
        }
        val startActivityLauncher2 :ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        )
        {
            //onActivityResult 부분
            when(it.resultCode){
                RESULT_OK->{
                    Log.d("xxx",it.data?.extras?.getString("result")!!)
                }
            }

            //onActivityResult 는
            //모든 intent가 한곳에서 처리된다. 구분이 필요하다
            //ActivityResult API는 intent가 처리되는 곳이 각각이다.
        }
        (findViewById<TextView>(R.id.intent_five)).apply{
            this.setOnClickListener{
                var intent:Intent=Intent(this@Intent_One,Intent_Two::class.java)
                startActivityLauncher2.launch(intent)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode){
            1->{
                when(resultCode){
                    RESULT_OK->{
                        val data:String?=data?.extras?.getString("result")
                        Log.d("xxx",data!!)
                    }
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}