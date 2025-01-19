package com.example.selectpartition.data.model

import com.google.gson.annotations.SerializedName

data class ProductSection(
    @SerializedName("status") val status: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("TOVARY") val selected: List<Section>?
)
