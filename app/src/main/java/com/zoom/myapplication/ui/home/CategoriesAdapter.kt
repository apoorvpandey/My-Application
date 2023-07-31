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
import com.zoom.myapplication.model.FoodCategory

class CategoriesAdapter(
    private val categoryList: List<FoodCategory>,
    private val context: Context
) :
    RecyclerView.Adapter<CategoriesAdapter.CarouselViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.category_layout, parent, false)
        return CarouselViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        val imageUrl = categoryList[position].icon
        Glide.with(context)
            .load(imageUrl)
            .centerCrop()
            .into(holder.imageView)

        holder.categoryName.text = categoryList[position].name

    }

    override fun getItemCount(): Int = categoryList.size

    class CarouselViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.category_image)
        val categoryName: TextView = itemView.findViewById(R.id.category_name)

    }
}
