package com.example.selectpartition.data.model

import com.google.gson.annotations.SerializedName

data class Section(
    @SerializedName("ID") val id: Int,
    @SerializedName("NAME") val name: String,
    @SerializedName("data") val products: List<Products>
)

