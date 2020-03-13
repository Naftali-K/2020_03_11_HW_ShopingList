package com.example.shopinglist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //checking if same number request and result of actions OK
        if(requestCode == NUMBER_REQUEST && resultCode == RESULT_OK){
            //if everything ok, going to here
            String stringFromExtra = data.getStringExtra("productList");

            Gson gson = new Gson();
            ArrayList<String> products = gson.fromJson(stringFromExtra, ArrayList.class);
            //Toast.makeText(getBaseContext(), "num items: " + products.size(), Toast.LENGTH_LONG).show();
            Toast.makeText(getBaseContext(), "items: " + products.get(0), Toast.LENGTH_LONG).show();

        }else{
            //if have any problem, so go to here

        }
    }
}
