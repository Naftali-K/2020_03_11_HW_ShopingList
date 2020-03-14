package com.example.shopinglist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnSelect;
    final int NUMBER_REQUEST = 11;
    ArrayList<String> products = new ArrayList();
    RecyclerView recyclerView;
    MainActivityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSelect = findViewById(R.id.btn_select);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Button pushed", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, ProductList.class);
                startActivityForResult(intent, NUMBER_REQUEST);
            }
        });

        //insert product list for test adapter
//        products.add("Product1");
//        products.add("Product2");
//        products.add("Product3");

        recyclerView = findViewById(R.id.rv_list);
        adapter = new MainActivityAdapter(products);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //checking if same number request and result of actions OK
        if(requestCode == NUMBER_REQUEST && resultCode == RESULT_OK){
            //if everything ok, going to here

            String stringFromExtra = data.getStringExtra("productList"); //Taking string (JSON) from Extra

            Gson gson = new Gson();
            products = gson.fromJson(stringFromExtra, ArrayList.class); //Changing string (JSON), to ArrayList.
                //Toast.makeText(getBaseContext(), "items: " + products.size(), Toast.LENGTH_LONG).show(); //testing, take item from list

            adapter = new MainActivityAdapter(products);
            recyclerView.setAdapter(adapter);

        }else{
            //if have any problem, so go to here

        }
    }
}
