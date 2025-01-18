package com.example.selectpartition.data.model

import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("ID") val id: Int,
    @SerializedName("DETAIL_PICTURE") val image: String,
    @SerializedName("PRICE") val price: String
)