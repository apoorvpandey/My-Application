package com.zoom.myapplication.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zoom.myapplication.R
import com.zoom.myapplication.model.Banner

class CarouselAdapter(private val imageList: List<Banner>, private val context: Context) :
    RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.carousel_item, parent, false)
        return CarouselViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        val imageUrl = imageList[position].imageUrl
        Glide.with(context)
            .load(imageUrl)
            .centerCrop()
            .into(holder.imageView)

    }

    override fun getItemCount(): Int = imageList.size

    class CarouselViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.carousel_image)

        fun bind(imageResId: Int) {
            imageView.setImageResource(imageResId)
        }
    }
}
