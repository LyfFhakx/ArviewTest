package com.example.arviewtest.data.repository

import androidx.lifecycle.LiveData
import com.example.arviewtest.data.Game
import com.example.arviewtest.data.Result
import com.example.arviewtest.data.network.Api
import com.example.arviewtest.domain.GameDataSource

class GameRemoteDataSource:GameDataSource {
    override fun observeGames(): LiveData<Result<List<Game>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getGames(): Result<List<Game>> {
        TODO("Not yet implemented")
    }

    override suspend fun saveGame(game: Game) {
        TODO("Not yet implemented")
    }

}