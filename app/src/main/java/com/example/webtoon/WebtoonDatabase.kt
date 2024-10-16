package com.example.webtoon
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

@Database(entities = [Webtoon::class], version = 1)
abstract class WebtoonDatabase : RoomDatabase() {

    abstract fun webtoonDao(): WebtoonDao

    companion object {
        @Volatile
        private var INSTANCE: WebtoonDatabase? = null

        fun getDatabase(context: Context): WebtoonDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WebtoonDatabase::class.java,
                    "webtoon_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
