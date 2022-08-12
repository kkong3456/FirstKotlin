package com.example.firstkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        val currentThread=Thread.currentThread()
        Log.d("testt",""+currentThread)

        // Thread 사용방법
//        Thread{
//            for(a in 1..100){
//                Log.d("testt","A"+a)
//            }
//        }.start()
//        Thread{
//            for(a in 1..100){
//                Log.d("testt","B"+a)
//            }
//        }.start()

        Thread{
            val currentThread=Thread.currentThread()
            Log.d("testt","A"+currentThread)
            //findViewById<TextView>(R.id.test).text="changed"
            //위의 findViewById.... UI변경을 메인쓰레드가 아닌 쓰레드에서 하려고 하면 해당 작업이 메인쓰레드의 queue로 들어간다.
            //그래서 에러가 안날수도 있다.==> 권장하지 않는다가 아니라 하지 마라...
            //대신 명시적으로 메인쓰레드에게 위임 runOnUiThread
            runOnUiThread{
                findViewById<TextView>(R.id.test).text="changed"
            }
        }.start()

    }
}