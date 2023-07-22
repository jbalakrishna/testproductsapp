package com.example.helloworldapplication.ui.main.network

import com.example.helloworldapplication.ui.main.cart.CartResponse
import com.example.helloworldapplication.ui.main.products.Product

interface ApiServices {
    suspend fun fetchProducts(page: Int): List<Product>
    suspend fun getCart(): CartResponse
    suspend fun addItemToCart(itemId: String): CartResponse
    suspend fun removeItemToCart(itemId: String): CartResponse
}
