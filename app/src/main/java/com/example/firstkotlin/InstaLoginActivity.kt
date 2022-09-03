package com.example.firstkotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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

            retrofitService.instaLogin(user).enqueue(object:Callback<User>{
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if(response.isSuccessful){
                        val user:User?=response.body()
                        Log.d("xxx","userToken is ${user?.token}")
                        val sharedPreferences=getSharedPreferences("user_info", Context.MODE_PRIVATE)
                        val editor:SharedPreferences.Editor=sharedPreferences.edit()
                        editor.putString("token",user?.token)
                        editor.putString("token",user?.id.toString())
                        editor.commit()

                        startActivity(Intent(this@InstaLoginActivity,InstaMainActivity::class.java))
                    }
                }
                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.d("xxx","서버와 통신에 실패하였습니다.")
                }
            })
        }
    }
}