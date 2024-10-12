package com.example.webtoon

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface WebtoonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteWebtoon(webtoon: FavoriteWebtoon)

    @Query("SELECT * FROM favorite_webtoons WHERE id = :id")
    suspend fun getFavoriteWebtoon(id: String): FavoriteWebtoon?

    @Update
    suspend fun updateWebtoonRating(id: String, rating: Float)

    @Query("SELECT * FROM favorite_webtoons")
    suspend fun getFavoriteWebtoons(): List<FavoriteWebtoon>
}
