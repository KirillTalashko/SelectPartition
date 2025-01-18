package com.example.selectpartition.data

import com.example.selectpartition.data.model.ProductSection
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/super_top.php?action=topglav")
    suspend fun getProduct(): Response<ProductSection>
}