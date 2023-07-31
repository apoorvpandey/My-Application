package com.zoom.myapplication.repository

import com.zoom.myapplication.model.ApiResponse
import com.zoom.myapplication.network.Api
import retrofit2.Response

class HomeRepository(private val api: Api) {
    suspend fun fetchData(): Response<ApiResponse> {
        return api.fetchData()
    }
}
