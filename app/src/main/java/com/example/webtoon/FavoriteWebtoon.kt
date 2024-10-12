package com.example.webtoon

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_webtoons")
data class FavoriteWebtoon(
    @PrimaryKey val id: String,  // Unique ID
    val title: String,
    val imageResId: Int,
    val description: String,
    var rating: Float = 0.0f
)
