package com.zoom.myapplication.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zoom.myapplication.R
import com.zoom.myapplication.model.RestaurantCollection

class RestaurantCollectionAdapter(
    private val restaurantCollections: List<RestaurantCollection>,
    private val context: Context
) : RecyclerView.Adapter<RestaurantCollectionAdapter.CollectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_collection, parent, false)
        return CollectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        val restaurantCollection = restaurantCollections[position]

        // Bind data to the views
        holder.collectionNameTextView.text = restaurantCollection.name

        // Use another RecyclerView for restaurants within the collection
        val restaurantRecyclerView =
            holder.itemView.findViewById<RecyclerView>(R.id.restaurantRecyclerView)
        restaurantRecyclerView.layoutManager =
            GridLayoutManager(context, 2) // 2 columns for the grid
        val restaurantAdapter = RestaurantAdapter(restaurantCollection.restaurants, context)
        restaurantRecyclerView.adapter = restaurantAdapter
    }

    override fun getItemCount(): Int {
        return restaurantCollections.size
    }

    inner class CollectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val collectionNameTextView: TextView =
            itemView.findViewById(R.id.collectionNameTextView)
    }
}
