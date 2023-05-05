package com.example.psychai

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("recommendations")
    fun getRecommendations(@Body request: Map<String, String>): Call<List<Map<String, String>>>
}
