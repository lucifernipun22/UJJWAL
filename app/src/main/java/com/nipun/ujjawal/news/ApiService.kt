package com.nipun.ujjawal.news

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/news")
    suspend fun getAgriNews (@Query("category") category : String
    ): NewsResponse
}