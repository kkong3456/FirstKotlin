package com.example.firstkotlin

import okhttp3.MultipartBody
import okhttp3.RequestBody
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
    ):Call<User>

    @POST("user/signup/")
    @FormUrlEncoded
    fun instaJoin(
        @FieldMap param:HashMap<String,Any>
    ):Call<User>

    @GET("instagram/post/list/all/")
    fun getInstagramPosts():Call<ArrayList<InstaPost>>

    @POST("instagram/post/like/{post_id}")
    fun postLike(
        @Path("post_id") post_id:Int
    ):Call<Any>

    @Multipart //이미지, 파일
    @POST("instagram/post/")
    fun uploadPost(
        @HeaderMap headers:Map<String, String>, //header에 사용자 구분을 위한 토큰을 보낸다.
        @Part image: MultipartBody.Part,        //이미지 보낼때
        @Part("content") content: RequestBody   //content 보낼때
    )

}

class YoutubeItem(
    val id:Int,val title:String, val content:String,val video:String, val thumbnail:String
)

class MelonItem(
    val id:Int, val title:String, val song:String, val thumbnail:String
):Serializable

class User(
    val username:String,val token:String,val id:Int
)

class InstaPost(
    val id:Int, val content:String, val image:String?, val owner_profile:OwnerProfile
)

class OwnerProfile(
    val username:String, val image:String?
)