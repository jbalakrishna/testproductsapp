package com.example.helloworldapplication.ui.main.products

interface ProductsListener {
    fun onClickProduct(id: String, position: Int)
    fun onClickProductButton(id: String, position: Int)
}
