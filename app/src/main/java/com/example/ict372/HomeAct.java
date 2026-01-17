package com.example.ict372;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class HomeAct extends AppCompatActivity {

    ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // CREATE PRODUCT LIST
        productList = new ArrayList<>();
        productList.add(new Product("Men's Suit","Formal business suit",250,R.drawable.suit));
        productList.add(new Product("Evening Dress","Elegant party dress",180,R.drawable.dress));
        productList.add(new Product("Blazer","Smart casual blazer",150,R.drawable.blazer));
        productList.add(new Product("Leather Shoes","Premium leather shoes",120,R.drawable.shoes));

        // IMAGE LINKS
        ImageView imgSuit = findViewById(R.id.imgSuit);
        ImageView imgDress = findViewById(R.id.imgDress);
        ImageView imgBlazer = findViewById(R.id.imgBlazer);
        ImageView imgShoes = findViewById(R.id.imgShoes);

        // CLICK LISTENERS → OPEN ProductDetailsAct
        imgSuit.setOnClickListener(v -> openDetails(productList.get(0)));
        imgDress.setOnClickListener(v -> openDetails(productList.get(1)));
        imgBlazer.setOnClickListener(v -> openDetails(productList.get(2)));
        imgShoes.setOnClickListener(v -> openDetails(productList.get(3)));

        // SEARCH BUTTON → SearchAct
        Button btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(v -> startActivity(new Intent(this, SearchAct.class)));
    }

    private void openDetails(Product product) {
        Intent intent = new Intent(this, ProductDetailsAct.class);
        intent.putExtra("product", product);
        startActivity(intent);
    }
}
