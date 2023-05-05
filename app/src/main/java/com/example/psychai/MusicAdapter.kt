package com.example.psychai

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MusicAdapter(private var recommendations: List<MusicRecommendation> = emptyList()) : RecyclerView.Adapter<MusicAdapter.ViewHolder>() {

    fun updateData(newRecommendations: List<MusicRecommendation>) {
        recommendations = newRecommendations
        Log.d("TAG", "New Recommendations: $recommendations")
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val artistTextView: TextView = itemView.findViewById(R.id.artistTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recommendation = recommendations[position]
        holder.titleTextView.setText(recommendation.title)
        holder.artistTextView.setText(recommendation.artist)
        Log.d("TAG", "List size: ${recommendations.size}")
        Log.d("MusicAdapter", "Title: ${recommendation.title}, Artist: ${recommendation.artist}")
    }

    override fun getItemCount(): Int = recommendations.size
}