package com.example.selectpartition.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Section(
    @SerializedName("ID") val id: Int,
    @SerializedName("NAME") val name: String,
    @SerializedName("data") val products: List<Products>
) : Parcelable

