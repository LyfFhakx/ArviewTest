package com.example.arviewtest

import android.content.Context
import androidx.annotation.VisibleForTesting
import com.example.arviewtest.data.local.AppDatabase
import com.example.arviewtest.data.repository.GameLocalDataSource
import com.example.arviewtest.data.repository.GameRepositoryImpl
import com.example.arviewtest.domain.GameDataSource
import com.example.arviewtest.domain.GameRepository

object Injector {

    @Volatile
    var gameRepository: GameRepository? = null
        @VisibleForTesting set

    fun provideGamesRepository(context: Context): GameRepository {
        synchronized(this) {
            return gameRepository ?: gameRepository ?: createGameRepository(context)
        }
    }

    private fun createGameRepository(context: Context): GameRepository {
        val newRepo = GameRepositoryImpl(createGameLocalDataSource(context))
        gameRepository = newRepo
        return newRepo
    }

    private fun createGameLocalDataSource(context: Context): GameDataSource {
        val database = AppDatabase.getInstance(context.applicationContext)
        return GameLocalDataSource(database.gameDao())
    }
}