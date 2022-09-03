package com.example.firstkotlin

import retrofit2.Call
import retrofit2.http.*
import java.io.Serializable


interface RetrofitService {
    @GET("json/students")
    fun getStudentList():Call<ArrayList<StudentFromServer>>

    @POST("json/students/")
    fun createStudent(
        @Body params:HashMap<String,Any>
    ):Call<StudentFromServer>

    @POST("json/students/") //post질의시 일반 raw데이터형식으로 요청
    fun easyCreateStudent(
        @Body student:StudentFromServer
    ):Call<StudentFromServer>

    //YouTube
    @GET("youtube/list/")
    fun getYoutubeItemList():Call<ArrayList<YoutubeItem>>

    //Melon
    @GET("melon/list/")
    fun getMelonItemList():Call<ArrayList<MelonItem>>

    //Insta, post질의시 데이터형식을 form-data형식으로 변경해서 요청
    @POST("user/login/")
    @FormUrlEncoded
    fun instaLogin(
        @FieldMap params:HashMap<String,Any>
    ):Call<UserToken>

    @POST("user/signup/")
    @FormUrlEncoded
    fun instaJoin(
        @FieldMap param:HashMap<String,Any>
    ):Call<UserToken>
}

class YoutubeItem(
    val id:Int,val title:String, val content:String,val video:String, val thumbnail:String
)

class MelonItem(
    val id:Int, val title:String, val song:String, val thumbnail:String
):Serializable

class UserToken(
    val username:String,val token:String
)