package com.example.helloworldapplication.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworldapplication.R
import com.example.helloworldapplication.ui.main.products.ProductsListAdapter
import com.example.helloworldapplication.ui.main.products.ProductsListener

class ProductsListingFragment : Fragment(), ProductsListener {

    companion object {
        fun newInstance() = ProductsListingFragment()
    }

    private lateinit var viewModel: ProductsListingViewModel

    private var productsList: RecyclerView? = null

    private var productsListAdapter = ProductsListAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_products_listing, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProductsListingViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productsList = view.findViewById<RecyclerView?>(R.id.product_listing).apply {
            adapter = productsListAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
        viewModel.products.observe(viewLifecycleOwner) {
            productsListAdapter.submitList(it)
        }
        viewModel.init()
    }

    override fun onClickProduct(id: String, position: Int) {
        viewModel.onClickProduct(id, position)
    }

    override fun onClickProductButton(id: String, position: Int) {
        viewModel.onClickProductAddToCart(id, position)
    }
}
