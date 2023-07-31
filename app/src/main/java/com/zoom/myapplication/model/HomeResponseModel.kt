package com.zoom.myapplication.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("status") val status: Int,
    @SerializedName("data") val data: Data
)

data class Data(
    @SerializedName("banners") val banners: List<Banner>,
    @SerializedName("food_categories") val foodCategories: List<FoodCategory>,
    @SerializedName("number_of_active_vouchers") val numberOfActiveVouchers: Int,
    @SerializedName("offer_collections") val offerCollections: List<OfferCollection>,
    @SerializedName("restaurant_collections") val restaurantCollections: List<RestaurantCollection>
)

data class Banner(
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("id") val id: Int
)

data class FoodCategory(
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("icon") val icon: String
)

data class OfferCollection(
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String,
    @SerializedName("textcolor") val textColor: String,
    @SerializedName("background") val background: String
)

data class RestaurantCollection(
    @SerializedName("name") val name: String,
    @SerializedName("priority") val priority: Int,
    @SerializedName("restaurants") val restaurants: List<Restaurant>
)

data class Restaurant(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("display_distance") val displayDistance: String,
    @SerializedName("rating") val rating: Float,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("offers") val offers: List<Offer>,
    @SerializedName("additional_offer") val additionalOffer: String? = null
)

data class Offer(
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("textcolor") val textColor: String? = null,
    @SerializedName("background") val background: String? = null
)
