package com.example.facebook.app

import com.example.facebook.app.dto.Posts
import retrofit2.Call
import retrofit2.http.GET

interface ReqResAPI {
    @GET("posts")
    fun getUsers():Call<MutableList<Posts>>
}