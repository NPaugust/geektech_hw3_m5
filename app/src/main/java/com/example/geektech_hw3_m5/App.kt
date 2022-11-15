package com.example.geektech_hw3_m5

import android.app.Application
import com.example.geektech_hw3_m5.model.PixabayApi
import com.example.geektech_hw3_m5.model.RetrofitService

class App:Application() {
    companion object{
        lateinit var api: PixabayApi
    }


    override fun onCreate() {
        super.onCreate()
        val  retrofitService = RetrofitService()
        api = retrofitService.api
    }
}