package com.example.shopinglist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityViewHolder> {

    ArrayList<String> products;

    public MainActivityAdapter(ArrayList<String> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public MainActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product, parent, false);
        return new MainActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainActivityViewHolder holder, int position) {
        holder.product.setText(products.get(position));
    }

    @Override
    public int getItemCount() {
        return this.products.size();
    }
}

class MainActivityViewHolder extends RecyclerView.ViewHolder {

    TextView product;

    public MainActivityViewHolder(@NonNull View itemView) {
        super(itemView);
        product = itemView.findViewById(R.id.product);
    }
}