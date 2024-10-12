package com.example.webtoon


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeActivity : AppCompatActivity() {
    private lateinit var webtoonAdapter: WebtoonAdapter
    private lateinit var webtoonList: List<Webtoon>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Use drawable resource IDs for the images
        webtoonList = listOf(
            Webtoon("1", "Lore Olympus", R.drawable.lore, "A modern retelling of the story of Hades and Persephone."),
            Webtoon("2", "Tower of God", R.drawable.tower, "A boy enters a mysterious tower to find his lost friend.")
            // Add more webtoons here with unique IDs
        )

        webtoonAdapter = WebtoonAdapter(webtoonList) { webtoon ->
            val intent = Intent(this, DetailActivity::class.java).apply{
                putExtra("webtoon_data", webtoon)
                startActivity(this)
            }
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = webtoonAdapter
    }
}
