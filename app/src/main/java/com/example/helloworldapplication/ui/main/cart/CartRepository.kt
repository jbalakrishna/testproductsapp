package com.example.helloworldapplication.ui.main.cart

interface CartRepository {
    fun getCachedCart(): CartResponse
    suspend fun getCart(): CartResponse
    suspend fun addItemToCart(itemId: String): CartResponse
    suspend fun removeItemToCart(itemId: String): CartResponse
}
