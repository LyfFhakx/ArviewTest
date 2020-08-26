package com.example.arviewtest.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.arviewtest.data.Game

@Dao
interface GameDao {

    @Query("SELECT * FROM games")
    fun observeGames(): LiveData<List<Game>>

    @Query("SELECT * FROM games")
    suspend fun getGames(): List<Game>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(Game: Game)
}