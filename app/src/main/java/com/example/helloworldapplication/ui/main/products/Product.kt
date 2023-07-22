package com.example.helloworldapplication.ui.main.products

data class Product(
    val id: String,
    val title: String,
    val desc: String?,
    val img: String,
    val sellingPrice: Float,
    val mrp: Float,
    val isInCart: Boolean = false
)
