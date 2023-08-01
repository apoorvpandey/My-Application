package com.zoom.myapplication.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zoom.myapplication.R
import com.zoom.myapplication.model.Restaurant

class RestaurantAdapter(
    private val restaurants: List<Restaurant>,
    private val context: Context
) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_restaurant, parent, false)
        return RestaurantViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = restaurants[position]

        // Bind data to the views
        // Load image using Glide or any other image loading library if needed
        Glide.with(context).load(restaurant.imageUrl).into(holder.restaurantImageView)
        holder.restaurantNameTextView.text = restaurant.name
        holder.restaurantRatingTextView.text = restaurant.rating.toString()
        // Display other restaurant data as needed, e.g., display_distance, offers, etc.
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }

    inner class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val restaurantImageView: ImageView = itemView.findViewById(R.id.restaurantImageView)
        val restaurantNameTextView: TextView = itemView.findViewById(R.id.restaurantNameTextView)
        val restaurantRatingTextView: TextView =
            itemView.findViewById(R.id.restaurantRatingTextView)
        // Add other views for displaying other restaurant data as needed
    }
}
