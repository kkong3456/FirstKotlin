package com.example.firstkotlin

import retrofit2.Call
import retrofit2.http.GET



interface RetrofitService {
    @GET("json/students")
    fun getStudentList():Call<ArrayList<StudentFromServer>>
}