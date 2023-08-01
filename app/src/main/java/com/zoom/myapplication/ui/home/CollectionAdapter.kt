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
import com.zoom.myapplication.model.OfferCollection

class CollectionAdapter(
    private val collectionList: List<OfferCollection>,
    private val context: Context
) :
    RecyclerView.Adapter<CollectionAdapter.CarouselViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.collection_layout, parent, false)
        return CarouselViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        val imageUrl = collectionList[position].image
        Glide.with(context)
            .load(imageUrl)
            .centerCrop()
            .into(holder.image)

        holder.name.text = collectionList[position].name

    }

    override fun getItemCount(): Int = collectionList.size

    class CarouselViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image)
        val name: TextView = itemView.findViewById(R.id.name)

    }
}
