package com.example.helloworldapplication.ui.main.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helloworldapplication.ui.main.Navigate
import com.example.helloworldapplication.ui.main.NavigateType
import com.example.helloworldapplication.ui.main.products.Product
import kotlinx.coroutines.launch

class CartViewModel : ViewModel() {
    private val repository = CartRepositoryRemoteImpl()

    private val _cartItems = MutableLiveData<List<Product>>()
    val cartItems: LiveData<List<Product>> = _cartItems

    private val _cartPriceInfo = MutableLiveData<CartPriceInfo>()
    val cartPriceInfo: LiveData<CartPriceInfo> = _cartPriceInfo

    init {
        repository.getCachedCart().apply {
            _cartItems.value = this.cartItems
            _cartPriceInfo.value = this.cartPriceInfo
        }
    }

    fun init() {
        viewModelScope.launch {
            try {
                repository.getCart().apply {
                    _cartItems.postValue(this.cartItems)
                    _cartPriceInfo.postValue(this.cartPriceInfo)
                }
            } catch (e: Exception) {
                //TODO error handling
            }
        }
    }

    fun onClickProduct(id: String, position: Int) {

    }

    fun onClickProductDelete(id: String, position: Int) {
        val currentList = _cartItems.value?.toMutableList() ?: return
//        val currentProduct = currentList.find { it.id == id } ?: return
        viewModelScope.launch {
            repository.removeItemToCart(id).apply {
                _cartItems.postValue(this.cartItems)
                _cartPriceInfo.postValue(this.cartPriceInfo)
            }
        }
    }
}
