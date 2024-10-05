package com.example.bai29api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface NetWork {
    companion object{
        val retrofit:Retrofit=Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val apiNetWork:NetWork= retrofit.create(NetWork::class.java)

    }
    @GET("/posts")
    fun getDataUser(): Call<List<User>>
}