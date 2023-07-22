package com.example.helloworldapplication.ui.main.products

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworldapplication.databinding.ProductItemBinding
import com.example.helloworldapplication.ui.main.Utils.Companion.prettyFormat

class ProductsListAdapter(val productsListener: ProductsListener): ListAdapter<Product, ProductsListAdapter.ProductItemViewHolder>(ProductsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
        return ProductItemViewHolder(
            ProductItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
        holder.bind(currentList[position], position)
    }

    inner class ProductItemViewHolder(val binding: ProductItemBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            binding.mrp.apply {
                paintFlags = this.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            }
        }
        fun bind(item: Product, position: Int) {
            with(binding) {
                title.text = item.title
                price.text = prettyFormat(item.sellingPrice)
                mrp.text = prettyFormat(item.mrp)
                root.setOnClickListener {
                    productsListener.onClickProduct(item.id, position)
                }
                addToCart.setOnClickListener {
                    productsListener.onClickProductButton(item.id, position)
                }
            }
        }
    }
}
