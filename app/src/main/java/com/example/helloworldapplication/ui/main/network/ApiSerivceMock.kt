package com.example.helloworldapplication.ui.main.network

import com.example.helloworldapplication.ui.main.cart.CartResponse
import com.example.helloworldapplication.ui.main.network.mock.MockProducts.Companion.currentCart
import com.example.helloworldapplication.ui.main.network.mock.MockProducts.Companion.productsPage1
import com.example.helloworldapplication.ui.main.products.Product
import kotlinx.coroutines.delay

class ApiServiceMock: ApiServices {
    override suspend fun getCart(): CartResponse {
        return currentCart
    }

    override suspend fun addItemToCart(itemId: String): CartResponse {
        val indexOfItem = currentCart.cartItems.indexOfFirst { it.id == itemId }
        if (indexOfItem < 0) {
            currentCart = currentCart.copy(
                cartItems = currentCart.cartItems.toMutableList().apply {
                    productsPage1.find { it.id == itemId }?.let {
                        add(it)
                    }
                }
            )
        }
        return currentCart
    }

    override suspend fun removeItemToCart(itemId: String): CartResponse {
        val indexOfItem = currentCart.cartItems.indexOfFirst { it.id == itemId }
        if (indexOfItem >= 0) {
            currentCart = currentCart.copy(
                cartItems = currentCart.cartItems.toMutableList().apply {
                    removeAt(indexOfItem)
                }
            )
        }
        return currentCart
    }

    override suspend fun fetchProducts(page: Int): List<Product> {
        delay(100)
        return productsPage1.map { product ->
            product.copy(
                isInCart = currentCart.cartItems.indexOfFirst { product.id == it.id } >= 0
            )
        }
    }
}
