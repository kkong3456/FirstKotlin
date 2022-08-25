package com.example.firstkotlin

import android.os.AsyncTask
import android.os.AsyncTask.execute
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
//NetworkOnMainThreadException
//메인쓰레드는 사용자 UI에만 사용해야 한다.
//
class NetworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        NetworkAsyncTask().execute()
    }
}

class NetworkAsyncTask(): AsyncTask<Any?,Any?,Any?>(){
    override fun doInBackground(vararg params: Any?): Any? {
        val urlString:String="http://mellowcode.org/json/students/"
        val url: URL =URL(urlString)

        val connection:HttpURLConnection=url.openConnection() as HttpURLConnection
        connection.requestMethod="GET"
        connection.setRequestProperty("Content/type","application/json")

        var buffer:String=""
        if(connection.responseCode==HttpURLConnection.HTTP_OK){
            val reader=BufferedReader(
                InputStreamReader(
                    connection.inputStream,
                    "UTF-8"
                )
            )
            buffer=reader.readLine()

            Log.d("xxx","buffer is "+buffer)
        }
        return null
    }
}