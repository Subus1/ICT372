package com.example.ict372;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private List<String> products;

    public CartAdapter(List<String> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.name.setText(products.get(position));
        holder.price.setText("$99.99"); // Fake price for now
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder {
        TextView name, price;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtProductName);
            price = itemView.findViewById(R.id.txtProductPrice);
        }
    }
}