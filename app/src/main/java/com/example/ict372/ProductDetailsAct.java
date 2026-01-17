package com.example.ict372;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailsAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        // UI Components
        Button btnBack = findViewById(R.id.btnBack);
        ImageView img = findViewById(R.id.imgProduct);
        TextView name = findViewById(R.id.txtName);
        TextView desc = findViewById(R.id.txtDesc);
        TextView price = findViewById(R.id.txtPrice);

        // Get Product passed from HomeAct or SearchAct
        Product product = (Product) getIntent().getSerializableExtra("product");

        if (product != null) {
            img.setImageResource(product.getImageResourceId());
            name.setText(product.getName());
            desc.setText(product.getDescription());
            price.setText(product.getFormattedPrice());
        }

        // Back Button → returns to previous screen
        btnBack.setOnClickListener(v -> finish());
    }
}
