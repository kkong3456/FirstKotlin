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
}