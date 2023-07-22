package com.example.helloworldapplication.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.helloworldapplication.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

}

/*

- product listing
- PDP
- cart
- summary
- payment -success/failure
E-commerce Shopping Cart App

Description:
You are assigned to develop an e-commerce shopping cart app that encompasses various aspects of Android development, including UI design, data management, payment integration, and user experience. The app should allow users to browse products, add items to their cart, proceed to checkout, and complete the payment process.

Features:

Fetch a list of products from a remote API endpoint.
Display the products in an appealing UI layout, including their images, names, prices, and ratings.
Allow users to add products to their shopping cart and manage the quantity of each item.
Implement features such as removing items, updating quantities, and calculating the total price.
Enable users to proceed to checkout and enter their shipping and payment information.
Integrate a payment gateway, such as Stripe or PayPal, to facilitate secure and seamless payments.


E-commerce Shopping Cart App


Description:

You are assigned to develop an e-commerce shopping cart app that encompasses various aspects of Android development, including UI design, data management, payment integration, and user experience. The app should allow users to browse products, add items to their cart, proceed to checkout, and complete the payment process.


Features:


Fetch a list of products from a remote API endpoint.

Display the products in an appealing UI layout, including their images, names, prices, and ratings.

Allow users to add products to their shopping cart and manage the quantity of each item.

Implement features such as removing items, updating quantities, and calculating the total price.

Enable users to proceed to checkout and enter their shipping and payment information.

Integrate a payment gateway, such as Stripe or PayPal, to facilitate secure and seamless payments.

 */
