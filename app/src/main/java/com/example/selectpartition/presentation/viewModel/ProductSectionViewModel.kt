package com.example.selectpartition.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.selectpartition.domain.repository.ProductSelectionRepository
import com.example.selectpartition.domain.state.ProductSectionFragmentState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductSectionViewModel(private val repository: ProductSelectionRepository) : ViewModel() {

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
                    if (productSelection.status == "Success") {
                        _stateProductSelection.postValue(productSelection.selected?.let {
                            ProductSectionFragmentState.SuccessProduct(it)
                        })
                    } else {
                        _stateProductSelection.postValue(
                            ProductSectionFragmentState.Error(
                                productSelection.message
                            )
                        )
                    }
                }
                    ?: run { _stateProductSelection.postValue(ProductSectionFragmentState.Error("Пустые данные")) }
            } catch (networkException: Exception) {
                _stateProductSelection.postValue(networkException.localizedMessage?.let {
                    ProductSectionFragmentState.Error(it)
                })
            }
        }
    }

}