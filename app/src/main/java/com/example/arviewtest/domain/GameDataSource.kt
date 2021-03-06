package com.example.arviewtest.domain

import androidx.lifecycle.LiveData
import com.example.arviewtest.data.Game
import com.example.arviewtest.data.Result

interface GameDataSource {

    fun observeGames(): LiveData<Result<List<Game>>>

    suspend fun getGames(): Result<List<Game>>

    suspend fun saveGame(game: Game)

}