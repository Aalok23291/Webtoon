package com.example.webtoon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WebtoonAdapter(private val webtoonList: List<Webtoon>, private val onItemClick: (Webtoon) -> Unit) : RecyclerView.Adapter<WebtoonAdapter.WebtoonViewHolder>() {

    class WebtoonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.webtoon_title)
        val image: ImageView = itemView.findViewById(R.id.webtoon_image)

        fun bind(webtoon: Webtoon) {
            title.text = webtoon.title
            image.setImageResource(webtoon.imageResId) // Assuming this is an Int resource ID
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebtoonViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_webtoon, parent, false) // Ensure this layout exists
        return WebtoonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WebtoonViewHolder, position: Int) {
        val webtoon = webtoonList[position]
        holder.bind(webtoon)

        // Set click listener for the entire item
        holder.itemView.setOnClickListener {
            onItemClick(webtoon) // Call the lambda function when item is clicked
        }
    }

    override fun getItemCount(): Int {
        return webtoonList.size
    }
}
