package com.example.arviewtest.domain

import androidx.lifecycle.LiveData
import com.example.arviewtest.data.Game
import com.example.arviewtest.data.Result

interface GameRepository {

    fun observeGames(): LiveData<List<Game>>

    suspend fun getGames():List<Game>

    suspend fun saveGame(game: Game)
}