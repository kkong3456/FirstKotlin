package com.example.firstkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InstaLoginActivity : AppCompatActivity() {
    var username:String=""
    var password:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insta_login)

        val retrofit= Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitService=retrofit.create(RetrofitService::class.java)

        findViewById<TextView>(R.id.id_input1).doAfterTextChanged{
            username=it.toString()
        }
        findViewById<TextView>(R.id.pw_input1).doAfterTextChanged{
            password=it.toString()
        }
        findViewById<TextView>(R.id.insta_join).setOnClickListener {
            startActivity(Intent(this,InstaJoinActivity::class.java))
        }
        findViewById<TextView>(R.id.login_btn).setOnClickListener {
            var user=HashMap<String,Any>()
            user.put("username",username)
            user.put("password",password)

            retrofitService.instaLogin(user).enqueue(object:Callback<UserToken>{
                override fun onResponse(call: Call<UserToken>, response: Response<UserToken>) {
                    if(response.isSuccessful){
                        val token:UserToken?=response.body()
                    }
                }
                override fun onFailure(call: Call<UserToken>, t: Throwable) {
                    Log.d("xxx","서버와 통신에 실패하였습니다.")
                }
            })
        }
    }
}