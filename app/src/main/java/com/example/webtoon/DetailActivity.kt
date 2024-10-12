package com.example.webtoon

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    private lateinit var titleTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail) // Ensure this layout file exists

        // Initialize your views
        titleTextView = findViewById(R.id.webtoon_title) // Make sure this ID is correct
        descriptionTextView = findViewById(R.id.webtoon_description) // Ensure this ID is correct
        imageView = findViewById(R.id.webtoon_image) // Ensure this ID is correct

        // Retrieve the webtoon data passed from the HomeActivity
        val webtoon = intent.getParcelableExtra<Webtoon>("webtoon_data") // Ensure that 'Webtoon' implements Parcelable

        // Check if webtoon is null
        if (webtoon != null) {
            // Set the data to views
            titleTextView.text = webtoon.title
            descriptionTextView.text = webtoon.description
            imageView.setImageResource(webtoon.imageResId)
        } else {
            // Handle the case where webtoon is null
            titleTextView.text = "Error"
            descriptionTextView.text = "No data available."
        }
    }
}
