package com.vero.sibs.ui.buy

import androidx.databinding.ObservableBoolean
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vero.core.model.Product
import com.vero.core_network_impl.ProductRepository
import kotlinx.coroutines.launch

class BuyViewModel @ViewModelInject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _productFetchingLiveData : MutableLiveData<List<Product>> = MutableLiveData()
    val productFetchingLiveData : LiveData<List<Product>> get() = _productFetchingLiveData

    val isLoading = ObservableBoolean(false)

    init {
        fetchProductList()
    }

    private fun fetchProductList() {
        isLoading.set(true)
        viewModelScope.launch {
            _productFetchingLiveData.postValue(productRepository.fetchProducts())
            isLoading.set(false)
        }
    }
}