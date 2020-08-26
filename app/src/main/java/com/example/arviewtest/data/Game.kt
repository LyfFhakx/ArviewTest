package com.example.arviewtest.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "games")
data class Game(
    @PrimaryKey
    @SerializedName("_id")
    var gameId:String,
    var logo: String,
    var name: String,
    var channels: Int,
    var viewers: Int
)