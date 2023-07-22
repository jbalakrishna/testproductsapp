package com.example.helloworldapplication.ui.main.cart

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworldapplication.databinding.ProductCartItemBinding
import com.example.helloworldapplication.ui.main.Utils
import com.example.helloworldapplication.ui.main.products.Product
import com.example.helloworldapplication.ui.main.products.ProductsDiffCallback
import com.example.helloworldapplication.ui.main.products.ProductsListener

class ProductCartItemsAdapter(val productsListener: ProductsListener) :
    ListAdapter<Product, ProductCartItemsAdapter.ProductCartItemViewHolder>(
        ProductsDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCartItemViewHolder {
        return ProductCartItemViewHolder(
            ProductCartItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductCartItemViewHolder, position: Int) {
        holder.bind(currentList[position], position)
    }

    inner class ProductCartItemViewHolder(val binding: ProductCartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.mrp.apply {
                paintFlags = this.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            }
        }

        fun bind(item: Product, position: Int) {
            with(binding) {
                title.text = item.title
                price.text = Utils.prettyFormat(item.sellingPrice)
                mrp.text = Utils.prettyFormat(item.mrp)
                root.setOnClickListener {
                    productsListener.onClickProduct(item.id, position)
                }
                deleteBtn.setOnClickListener {
                    productsListener.onClickProductButton(item.id, position)
                }
            }
        }
    }
}
