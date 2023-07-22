package com.example.helloworldapplication.ui.main.cart

import com.example.helloworldapplication.ui.main.products.Product

data class CartResponse(
    val cartItems: List<Product>,
    val cartPriceInfo: CartPriceInfo
)
