package com.example.firstkotlin

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface RetrofitService {
    @GET("json/students")
    fun getStudentList():Call<ArrayList<StudentFromServer>>

    @POST("json/students/")
    fun createStudent(
        @Body params:HashMap<String,Any>
    ):Call<StudentFromServer>

    @POST("json/students/")
    fun easyCreateStudent(
        @Body student:StudentFromServer
    ):Call<StudentFromServer>

    //YouTube
    @GET("youtube/list/")
    fun getYoutubeItemList():Call<ArrayList<YoutubeItem>>
}

class YoutubeItem(
    val id:Int,val title:String, val content:String,val video:String, val thumbnail:String
)