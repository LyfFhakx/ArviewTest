package com.example.arviewtest.data.network

import com.example.arviewtest.data.Game
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

interface Api {

    @GET("/game")
    suspend fun getGames():Response<List<Game>>

    @Suppress("FunctionName")
    fun initRetrofit():Api {
        return Retrofit.Builder()
            .baseUrl("https://api.twitch.tv/kraken/games/top")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }
}