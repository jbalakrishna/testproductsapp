package com.example.helloworldapplication.ui.main.network.mock

import com.example.helloworldapplication.ui.main.network.PaymentServices
import kotlinx.coroutines.delay

class PaymentServicesMock: PaymentServices {
    override suspend fun payOnline(id: String, totalValue: Float): Boolean {
        delay(2000)
        return true
    }
}
