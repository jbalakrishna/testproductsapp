package com.example.helloworldapplication.ui.main

data class Navigate(
    val type: NavigateType,
    val data: String
)

enum class NavigateType {
    PDP
}
