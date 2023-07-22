package com.example.helloworldapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.helloworldapplication.databinding.ActivityMainBinding
import com.example.helloworldapplication.ui.main.MainFragment
import com.example.helloworldapplication.ui.main.ProductsListingFragment
import com.example.helloworldapplication.ui.main.cart.CartFragment
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    var fragments: List<Fragment> = emptyList()

    var binding: ActivityMainBinding? = null

    var currentItem = R.id.product_listing
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(
            LayoutInflater.from(this)
        )
        setContentView(binding!!.root)
        fragments = listOf(
            ProductsListingFragment.newInstance(),
            CartFragment.newInstance()
        )
        supportFragmentManager.beginTransaction().add(
            R.id.container,
            fragments[0]
        ).commit()
        binding?.bottomNav?.setOnItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.itemId == currentItem) {
            return false
        }
        val productFragment = fragments[0]
        val cartFragment = fragments[1]
        if (item.itemId == R.id.product_listing) {
            if (cartFragment.isAdded) {
                supportFragmentManager.beginTransaction().hide(cartFragment).commit()
            }
            supportFragmentManager.beginTransaction().show(productFragment).commit()
        } else {
            if (!cartFragment.isAdded) {
                supportFragmentManager.beginTransaction().add(
                    R.id.container,
                    cartFragment
                ).commit()
            }
            supportFragmentManager.beginTransaction().hide(productFragment).show(cartFragment).commit()
        }
        currentItem = item.itemId
        return true
    }
}
