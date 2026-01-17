package com.example.ict372;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HomeAct extends AppCompatActivity {

    ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnSearch = findViewById(R.id.btnSearch);
        Button btnCart = findViewById(R.id.btnCart);
        LinearLayout layoutProducts = findViewById(R.id.layoutProducts);

        // Products
        products = new ArrayList<>();
        products.add(new Product("Men Suit","Formal suit",250,R.drawable.suit));
        products.add(new Product("Evening Dress","Party dress",180,R.drawable.dress));
        products.add(new Product("Blazer","Casual blazer",150,R.drawable.blazer));
        products.add(new Product("Leather Shoes","Footwear",120,R.drawable.shoes));

        LayoutInflater inflater = LayoutInflater.from(this);

        for (Product p : products){
            LinearLayout card = (LinearLayout) inflater.inflate(R.layout.item_product, null);

            ImageView img = card.findViewById(R.id.imgProduct);
            TextView name = card.findViewById(R.id.txtProductName);
            TextView price = card.findViewById(R.id.txtProductPrice);

            img.setImageResource(p.getImageResourceId());
            name.setText(p.getName());
            price.setText(p.getFormattedPrice());

            card.setOnClickListener(v -> {
                Intent intent = new Intent(HomeAct.this, ProductDetailsAct.class);
                intent.putExtra("product", p);
                startActivity(intent);
            });

            layoutProducts.addView(card);
        }

        btnSearch.setOnClickListener(v -> startActivity(new Intent(HomeAct.this, SearchAct.class)));
        btnCart.setOnClickListener(v -> {
            // placeholder for cart
        });
    }
}
