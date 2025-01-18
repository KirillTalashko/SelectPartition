package com.example.selectpartition.domain.state

import com.example.selectpartition.data.model.Section

sealed class ProductSectionFragmentState {
    data class Error(val error: String) : ProductSectionFragmentState()
    data class SuccessProduct(val product: List<Section>) : ProductSectionFragmentState()
    data object LoadingProduct : ProductSectionFragmentState()
}