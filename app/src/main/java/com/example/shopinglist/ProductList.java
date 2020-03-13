package com.example.shopinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductList extends AppCompatActivity {

    ArrayList<String> productList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        makeListProduct();
        //Toast.makeText(ProductList.this, "Num Product " + DataManager.product.size(), Toast.LENGTH_LONG).show();

        RecyclerView rv = findViewById(R.id.rv_body);
        ProductListAdapter adapter = new ProductListAdapter();
        rv.setAdapter(adapter);

        findViewById(R.id.btn_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //toastPrint("Totally add: " + productList.size() + " items");//testing code

                /*
                For use JSONArray, need use like normal array.
                To variable of JASONArray, you add value by value (or Object)
                 */
                JSONArray objectArray = new JSONArray();
                for(String item: productList){
                    objectArray.put(item);
                }

                Intent intent = new Intent();
                intent.putExtra("productList", objectArray.toString());

                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

    }

    public void makeListProduct(){
        DataManager.addProduct("milk");
        DataManager.addProduct("Water");
        DataManager.addProduct("Flour");
        DataManager.addProduct("Bread");
        DataManager.addProduct("Vodka");
        DataManager.product.add("Orange");
    }

    public void onClickCheckBox(View view){
        boolean checked = ((CheckBox) view).isChecked();
        String text = ((CheckBox) view).getText().toString();
        //toastPrint(text);
        //Toast.makeText(ProductList.this, text, Toast.LENGTH_LONG).show();

        if(checked){
            //add new product to the list
            //toastPrint("Add product: " + text);

            productList.add(text);//add item/product to list
        }else{
            //remove product from list
            //toastPrint("Remove product: " + text);

            int indexOfProduct = productList.indexOf(text); //getting index product that was add to the list
            productList.remove(indexOfProduct); //removing the item
        }
    }

    //function for Toast
    public void toastPrint(String text){
        Toast.makeText(getBaseContext(), text, Toast.LENGTH_LONG).show();
    }
}
