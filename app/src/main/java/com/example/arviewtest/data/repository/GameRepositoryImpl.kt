package com.example.arviewtest.data.repository

import androidx.lifecycle.LiveData
import com.example.arviewtest.data.Game
import com.example.arviewtest.data.Result
import com.example.arviewtest.data.network.Api
import com.example.arviewtest.domain.GameDataSource
import com.example.arviewtest.domain.GameRepository
import kotlinx.coroutines.*

class GameRepositoryImpl(
    private val gameLocalDataSource: GameDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) :GameRepository{
    override fun observeGames(): LiveData<Result<List<Game>>> {
        return gameLocalDataSource.observeGames()
    }

    override suspend fun getGames(forceUpdate: Boolean): Result<List<Game>>  {
        return gameLocalDataSource.getGames()
    }

    override suspend fun saveGame(game: Game) {
        coroutineScope {
            launch{
                gameLocalDataSource.saveGame(game)
            }
        }
    }


}