package com.example.webtoon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FavoriteAdapter(private var favoriteWebtoons: List<FavoriteWebtoon>) : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite_webtoon, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val favoriteWebtoon = favoriteWebtoons[position]
        holder.title.text = favoriteWebtoon.title
        // Load image using an image loading library, like Glide or Picasso
        // Glide.with(holder.itemView.context).load(favoriteWebtoon.imageUrl).into(holder.image)
    }

    override fun getItemCount(): Int = favoriteWebtoons.size

    // Update the adapter data with a new list of favorite webtoons
    fun updateData(newFavorites: List<FavoriteWebtoon>) {
        favoriteWebtoons = newFavorites
        notifyDataSetChanged()
    }

    class FavoriteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.favorite_webtoon_title)
        val image: ImageView = view.findViewById(R.id.favorite_webtoon_image)
    }
}
