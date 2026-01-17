package com.example.ict372;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SearchAct extends AppCompatActivity {

    ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        AutoCompleteTextView autoCompleteSearch = findViewById(R.id.autoCompleteSearch);
        Button btnSearch = findViewById(R.id.btnSearch);
        Button btnBack = findViewById(R.id.btnBack);
        TextView txtResult = findViewById(R.id.txtResult);

        // Initialize products
        products = new ArrayList<>();
        products.add(new Product("Men Suit","Formal suit",250,R.drawable.suit));
        products.add(new Product("Evening Dress","Party dress",180,R.drawable.dress));
        products.add(new Product("Blazer","Casual blazer",150,R.drawable.blazer));
        products.add(new Product("Leather Shoes","Footwear",120,R.drawable.shoes));

        // Setup adapter for type-ahead suggestions
        ArrayList<String> productNames = new ArrayList<>();
        for(Product p : products){
            productNames.add(p.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                productNames
        );

        autoCompleteSearch.setAdapter(adapter);

        // Search logic
        btnSearch.setOnClickListener(v -> {
            String keyword = autoCompleteSearch.getText().toString().trim();
            boolean found = false;

            for(Product p : products){
                if(p.getName().equalsIgnoreCase(keyword)){
                    Intent intent = new Intent(SearchAct.this, ProductDetailsAct.class);
                    intent.putExtra("product", p);
                    startActivity(intent);
                    found = true;
                    break;
                }
            }

            if(!found){
                txtResult.setText("No product found");
            } else {
                txtResult.setText("");
            }
        });

        btnBack.setOnClickListener(v -> finish());
    }
}
