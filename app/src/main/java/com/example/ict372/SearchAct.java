package com.example.ict372;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class SearchAct extends AppCompatActivity {

    ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        EditText edtSearch = findViewById(R.id.edtSearch);
        Button btnSearch = findViewById(R.id.btnSearch);
        Button btnBack = findViewById(R.id.btnBack);
        TextView txtResult = findViewById(R.id.txtResult);

        // Create product list (same as Home)
        products = new ArrayList<>();
        products.add(new Product("Men Suit","Formal suit",250,R.drawable.suit));
        products.add(new Product("Evening Dress","Party dress",180,R.drawable.dress));
        products.add(new Product("Blazer","Casual blazer",150,R.drawable.blazer));
        products.add(new Product("Leather Shoes","Footwear",120,R.drawable.shoes));

        // Search button logic
        btnSearch.setOnClickListener(v -> {
            String keyword = edtSearch.getText().toString().toLowerCase();

            for (Product p : products) {
                if (p.getName().toLowerCase().contains(keyword)) {
                    // Open ProductDetailsAct
                    Intent intent = new Intent(SearchAct.this, ProductDetailsAct.class);
                    intent.putExtra("product", p);
                    startActivity(intent);
                    return;
                }
            }

            // No result found
            txtResult.setText("No product found");
        });

        // Back button logic
        btnBack.setOnClickListener(v -> finish()); // closes SearchAct, returns to HomeAct
    }
}
