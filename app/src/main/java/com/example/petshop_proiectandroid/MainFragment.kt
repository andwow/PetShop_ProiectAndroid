package com.example.petshop_proiectandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petshop_proiectandroid.adapters.MainAdapter
import com.example.petshop_proiectandroid.interfaces.OnShopItemClick
import com.example.petshop_proiectandroid.models.Shop

class MainFragment: Fragment() {
    private val shops: ArrayList<Shop> = ArrayList()
    private val onShopItemClick: OnShopItemClick = OnShopItemClick {}
    private val mainAdapter: MainAdapter = MainAdapter(shops, onShopItemClick)
    companion object {
        fun newInstance() : Fragment {
            return Fragment()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        setUpRecyclerView(view)
        return view
    }

    private fun setUpRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.main_fragment);
        val linearLayoutManager = LinearLayoutManager(view.context);
        shops.add(Shop(1, "123", "123"))
        recyclerView.layoutManager = linearLayoutManager
        val adapter = MainAdapter(shops, OnShopItemClick {})
        recyclerView.adapter=adapter
    }
}