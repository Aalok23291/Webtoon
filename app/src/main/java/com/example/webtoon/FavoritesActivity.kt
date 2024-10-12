package com.example.webtoon
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritesActivity : AppCompatActivity() {
    private lateinit var favoriteAdapter: FavoriteAdapter
    private lateinit var webtoonDatabase: WebtoonDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        webtoonDatabase = WebtoonDatabase.getDatabase(this)
        favoriteAdapter = FavoriteAdapter(listOf())

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_favorites)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = favoriteAdapter

        loadFavorites()
    }

    private fun loadFavorites() {
        CoroutineScope(Dispatchers.IO).launch {
            val favoriteWebtoons = webtoonDatabase.webtoonDao().getFavoriteWebtoons()
            runOnUiThread {
                favoriteAdapter.updateData(favoriteWebtoons) // This now works with FavoriteWebtoon
            }
        }
    }

}
