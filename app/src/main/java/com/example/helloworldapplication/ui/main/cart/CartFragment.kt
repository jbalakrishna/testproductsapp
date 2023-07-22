package com.example.helloworldapplication.ui.main.cart

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworldapplication.R
import com.example.helloworldapplication.ui.main.products.ProductsListener

class CartFragment : Fragment(), ProductsListener {

    companion object {
        fun newInstance() = CartFragment()
    }

    private lateinit var viewModel: CartViewModel

    private val productCartItemsAdapter = ProductCartItemsAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        viewModel.cartPriceInfo.observe(viewLifecycleOwner) {

        }
        viewModel.cartItems.observe(viewLifecycleOwner) {

        }
        viewModel.init()
        view?.findViewById<RecyclerView>(R.id.cart_items_list)?.apply {
            adapter = productCartItemsAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun onClickProduct(id: String, position: Int) {
        viewModel.onClickProduct(id, position)
    }

    override fun onClickProductButton(id: String, position: Int) {
        viewModel.onClickProductDelete(id, position)
    }
}
