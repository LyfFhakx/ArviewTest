package com.example.arviewtest.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.arviewtest.data.Game
import com.example.arviewtest.data.Result
import com.example.arviewtest.data.local.dao.GameDao
import com.example.arviewtest.domain.GameDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GameLocalDataSource internal constructor(
    private val gameDao: GameDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : GameDataSource {

    override fun observeGames(): LiveData<Result<List<Game>>> {
        return gameDao.observeGames().map {
            Result.Success(it)
        }
    }

    override suspend fun getGames(): Result<List<Game>> = withContext(ioDispatcher) {
        return@withContext try {
            Result.Success(gameDao.getGames())
        } catch (e: Exception) {
            Error(e)
        }
    }

    override suspend fun saveGame(game: Game) = withContext(ioDispatcher) {
        gameDao.insertGame(game)
    }
}

