package com.example.selectpartition.domain.repository

import com.example.selectpartition.data.RetrofitClient
import com.example.selectpartition.data.model.ProductSection
import retrofit2.Response

class ProductSelectionRepositoryImpl : ProductSelectionRepository {

    override suspend fun getProductSelection(): Response<ProductSection> {
        return RetrofitClient().getClient().getProduct()
    }

}