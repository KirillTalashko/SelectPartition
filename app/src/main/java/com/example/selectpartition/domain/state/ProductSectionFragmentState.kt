package com.example.selectpartition.domain.state

import com.example.selectpartition.data.model.Section

sealed class ProductSectionFragmentState {
    data class Error(val error: String) : ProductSectionFragmentState()
    data class SuccessProduct(val section: List<Section>) : ProductSectionFragmentState()
    data object LoadingProduct : ProductSectionFragmentState()
}