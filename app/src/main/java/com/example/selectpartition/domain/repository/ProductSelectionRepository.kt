package com.example.selectpartition.domain.repository

import com.example.selectpartition.data.model.ProductSection
import retrofit2.Response

interface ProductSelectionRepository {

    suspend fun getProductSelection(): Response<ProductSection>
}