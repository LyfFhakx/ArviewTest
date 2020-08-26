package com.example.arviewtest

import android.app.Application
import com.example.arviewtest.data.network.Api
import com.example.arviewtest.data.network.AuthInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class GameApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initRetrofit()
    }

    @Suppress("FunctionName")
    fun initRetrofit():Api {
        return Retrofit.Builder()
            .baseUrl("https://api.twitch.tv/kraken/games/top")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

}