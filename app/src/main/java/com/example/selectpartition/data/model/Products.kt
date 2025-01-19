package com.example.selectpartition.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Products(
    @SerializedName("ID") val id: Int,
    @SerializedName("DETAIL_PICTURE") val image: String,
    @SerializedName("CATALOG_PURCHASING_CURRENCY") val currency: String?,
    @SerializedName("EXTENDED_PRICE") val listPrice: List<Price>
) : Parcelable