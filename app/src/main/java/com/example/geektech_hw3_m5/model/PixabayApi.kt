package com.example.geektech_hw3_m5.model


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {
    @GET("api/")
    fun getImage(@Query("key")key:String = "31346495-ce492d2ab7624030b23fc93d5",
                  @Query("q") keyWord:String,
                  @Query("page") page: Int = 1,
                  @Query("per page") perPage: Int = 5
    ): Call<PixabayModel>



}
