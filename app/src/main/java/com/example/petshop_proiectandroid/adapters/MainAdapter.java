package com.example.petshop_proiectandroid.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petshop_proiectandroid.R;
import com.example.petshop_proiectandroid.interfaces.OnShopItemClick;
import com.example.petshop_proiectandroid.models.Shop;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Shop> shops;
    private OnShopItemClick onShopItemClick;
    public MainAdapter(ArrayList<Shop> userList, OnShopItemClick onShopItemClick) {
        this.shops = userList;
        this.onShopItemClick = onShopItemClick;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.shop_cell, parent, false);
        ShopViewHolder shopViewHolder = new ShopViewHolder(view);
        return shopViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Shop shop = (Shop)shops.get(position);
        ((ShopViewHolder) holder).bind(shop);
    }

    @Override
    public int getItemCount() {
        return this.shops.size();
    }

    class ShopViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView location;
        private View view;

        ShopViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.shop_name);
            location = view.findViewById(R.id.location);
            this.view = view;
        }

        void bind(Shop shop) {
            name.setText(shop.getName());
            location.setText(shop.getLocation());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onShopItemClick.onClick(shop);
                }
            });
        }


    }
}