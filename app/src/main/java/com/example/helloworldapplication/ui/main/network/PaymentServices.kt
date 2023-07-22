package com.example.helloworldapplication.ui.main.network

interface PaymentServices {
    suspend fun payOnline(id: String, totalValue: Float): Boolean
}
