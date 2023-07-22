package com.example.helloworldapplication.ui.main.cart

import com.example.helloworldapplication.ui.main.network.ApiServiceMock
import com.example.helloworldapplication.ui.main.network.Utils.Companion.isInternetAvailable

class CartRepositoryRemoteImpl: CartRepository {

    private val apiServices = ApiServiceMock()
    // below can be read from cache
    private var cartResponse = CartResponse(cartItems = emptyList(), cartPriceInfo = CartPriceInfo(totalPrice = 0f, payablePrice = 0f))
    override fun getCachedCart(): CartResponse {
        return cartResponse
    }

    override suspend fun getCart(): CartResponse {
        return if (isInternetAvailable()) {
            apiServices.getCart().apply {
                cartResponse = this
            }
        } else {
            cartResponse
        }
    }

    override suspend fun addItemToCart(itemId: String): CartResponse {
        return apiServices.addItemToCart(itemId).apply {
            cartResponse = this
        }
    }

    override suspend fun removeItemToCart(itemId: String): CartResponse {
        return apiServices.removeItemToCart(itemId).apply {
            cartResponse = this
        }
    }
}
