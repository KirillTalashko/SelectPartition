package com.example.selectpartition.presentation.fragment.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.selectpartition.domain.repository.ProductSelectionRepository
import com.example.selectpartition.domain.state.ProductSectionFragmentState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductSectionViewModel(
    private val repository: ProductSelectionRepository,
    private val error: String
) : ViewModel() {

    private val _stateProductSelection =
        MutableLiveData<ProductSectionFragmentState>(ProductSectionFragmentState.LoadingProduct)
    val stateProductSelection: LiveData<ProductSectionFragmentState>
        get() = _stateProductSelection

    init {
        getProductSelection()
    }

    private fun getProductSelection() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _stateProductSelection.postValue(ProductSectionFragmentState.LoadingProduct)
                val response = repository.getProductSelection()
                response.body()?.let { productSelection ->
                    Log.i("youTag", "$productSelection")
                    /*if (productSelection.status) {
                        _stateProductSelection.postValue(productSelection.selected?.let {
                            ProductSectionFragmentState.SuccessProduct(it)
                        })
                    } else {
                        _stateProductSelection.postValue(
                            ProductSectionFragmentState.Error(
                                productSelection.message
                            )
                        )
                    }*/ //TODO Error in the status field, it always returns false
                    _stateProductSelection.postValue(productSelection.selected?.let {
                        ProductSectionFragmentState.SuccessProduct(it)
                    })
                } ?: run {
                    _stateProductSelection.postValue(
                        ProductSectionFragmentState.Error(
                            error
                        )
                    )
                }
            } catch (networkException: Exception) {
                _stateProductSelection.postValue(networkException.localizedMessage?.let {
                    ProductSectionFragmentState.Error(it)
                })
            }
        }
    }

}