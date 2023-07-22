package com.example.helloworldapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helloworldapplication.ui.main.cart.CartRepositoryRemoteImpl
import com.example.helloworldapplication.ui.main.network.ApiServiceMock
import com.example.helloworldapplication.ui.main.products.Product
import kotlinx.coroutines.launch

class ProductsListingViewModel() : ViewModel() {

    private val apiServices = ApiServiceMock()
    private val cartRepository = CartRepositoryRemoteImpl()

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products
    private var currentPage: Int = 0
    private var isLoading: Boolean = false

    val navigateAction = MutableLiveData<Navigate>()

    fun init() {
        fetchProducts(true, isPagination = false)
    }

    fun refresh() {
        fetchProducts(true, isPagination = false)
    }

    fun lazyCall() {
        fetchProducts(isRefresh = false, isPagination = true)
    }

    private fun fetchProducts(isRefresh: Boolean, isPagination: Boolean) {
        if (isRefresh) {
            currentPage = 0
        }
        if (isPagination) {
            if (isLoading) return
            isLoading = true
        }
        viewModelScope.launch {
            try {
                val result = apiServices.fetchProducts(currentPage)
                if (isRefresh) {
                    _products.postValue(result)
                } else {
                    val existing = (_products.value ?: emptyList()).toMutableList()
                    _products.postValue(existing.apply {
                        addAll(result)
                    })
                    currentPage += 1
                }
            } catch (e: Exception) {
                //TODO error handle
            }
        }
    }

    fun onClickProduct(id: String, position: Int) {
        navigateAction.value = Navigate(
            NavigateType.PDP,
            id
        )
    }

    fun onClickProductAddToCart(id: String, position: Int) {
        val currentList = _products.value?.toMutableList() ?: return
        val currentProduct = currentList.find { it.id == id } ?: return
        viewModelScope.launch {
            val isSuccess = if (currentProduct.isInCart) {
                removeFromCart(currentProduct)
            } else {
                addToCart(currentProduct)
            }
            if (isSuccess) {
                currentList[position] = currentProduct.copy(
                    isInCart = !currentProduct.isInCart
                )
                _products.postValue(currentList)
            }
        }
    }

    private suspend fun addToCart(currentProduct: Product): Boolean {
        return try {
            cartRepository.addItemToCart(currentProduct.id)
            true
        } catch (e: Exception) {
            //TODO error handle
            false
        }
    }

    private suspend fun removeFromCart(currentProduct: Product): Boolean {
        return try {
            cartRepository.addItemToCart(currentProduct.id)
            true
        } catch (e: Exception) {
            //TODO error handle
            false
        }
    }
}
