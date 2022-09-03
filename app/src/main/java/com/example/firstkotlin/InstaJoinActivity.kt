package com.example.firstkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InstaJoinActivity : AppCompatActivity() {
    var username:String=""
    var password11:String=""
    var password22:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insta_join)

        findViewById<TextView>(R.id.insta_login).setOnClickListener {
            startActivity(Intent(this,InstaLoginActivity::class.java))
        }
        findViewById<EditText>(R.id.id_input1).doAfterTextChanged { username=it.toString()}
        findViewById<EditText>(R.id.pw_input11).doAfterTextChanged { password11=it.toString() }
        findViewById<EditText>(R.id.pw_input22).doAfterTextChanged { password22=it.toString()  }

        val retrofit= Retrofit.Builder()
            .baseUrl("http://mellowcode.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitService=retrofit.create(RetrofitService::class.java)


        findViewById<TextView>(R.id.join_btn).setOnClickListener {
            val user=HashMap<String,Any>()
            user.put("username",username)
            user.put("password1",password11)
            user.put("password2",password22)

            retrofitService.instaJoin(user).enqueue(object: Callback<UserToken>{
                override fun onResponse(call: Call<UserToken>, response: Response<UserToken>) {
                    Log.d("xxx","통신성공")
//                    response.setContentType("text/html;charset=utf-8");

                    if(response.isSuccessful){
                        val userToken=response.body()
                        Log.d("xxx","userToken is $userToken")
                    }
                }

                override fun onFailure(call: Call<UserToken>, t: Throwable) {
                    Log.d("xxx","서버와 통신에 실패하였습니다.")
                }
            })
        }
    }
}