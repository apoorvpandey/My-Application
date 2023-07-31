package com.zoom.myapplication.network

import com.zoom.myapplication.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("v1/0c5d380f-972a-44c9-bd11-ca5a2f154019")
    suspend fun fetchData(): Response<ApiResponse>
}
