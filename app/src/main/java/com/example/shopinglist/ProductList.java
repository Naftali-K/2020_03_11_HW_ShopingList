package com.example.shopinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        makeListProduct();
        //Toast.makeText(ProductList.this, "Num Product " + DataManager.product.size(), Toast.LENGTH_LONG).show();

        RecyclerView rv = findViewById(R.id.rv_body);
        ProductListAdapter adapter = new ProductListAdapter();
        rv.setAdapter(adapter);

    }

    public void makeListProduct(){
        DataManager.addProduct("milk");
        DataManager.addProduct("Water");
        DataManager.addProduct("Flour");
        DataManager.addProduct("Bread");
        DataManager.addProduct("Vodka");
        DataManager.product.add("Orange");
    }
}
