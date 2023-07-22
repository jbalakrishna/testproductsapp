package com.example.helloworldapplication.ui.main.network.mock

import com.example.helloworldapplication.ui.main.cart.CartPriceInfo
import com.example.helloworldapplication.ui.main.cart.CartResponse
import com.example.helloworldapplication.ui.main.products.Product

class MockProducts {
    companion object {
        val productsPage1 = listOf(
            Product(
                title = "This is my first product",
                desc = null,
                sellingPrice = 2000f,
                mrp = 2999f,
                img = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjnvYeBMSOOgIaxAfQ1PUPmsZ76knZtrdO867cKVmibw&s",
                id = "1"
            ),
            Product(
                title = "This is my first product",
                desc = null,
                sellingPrice = 2000f,
                mrp = 2999f,
                img = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjnvYeBMSOOgIaxAfQ1PUPmsZ76knZtrdO867cKVmibw&s",
                id = "2"
            ),
            Product(
                title = "This is my first product",
                desc = null,
                sellingPrice = 2000f,
                mrp = 2999f,
                img = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjnvYeBMSOOgIaxAfQ1PUPmsZ76knZtrdO867cKVmibw&s",
                id = "3"
            ),
            Product(
                title = "This is my first product",
                desc = null,
                sellingPrice = 2000f,
                mrp = 2999f,
                img = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjnvYeBMSOOgIaxAfQ1PUPmsZ76knZtrdO867cKVmibw&s",
                id = "4"
            ),
        )
        var currentCart = CartResponse(
            emptyList(),
            CartPriceInfo(0f, 0f)
        )
    }
}
