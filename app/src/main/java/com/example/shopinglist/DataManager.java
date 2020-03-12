package com.example.shopinglist;

import java.util.ArrayList;

public class DataManager {
    static ArrayList<String> product = new ArrayList();

    public static ArrayList getProduct() {
        return product;
    }

    public static void setProduct(ArrayList product) {
        DataManager.product = product;
    }

    public static void addProduct(String newProduct){
        product.add(newProduct);
    }
}
