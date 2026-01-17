package com.example.ict372;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailsAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        ImageView imgProduct = findViewById(R.id.imgProduct);
        TextView txtName = findViewById(R.id.txtName);
        TextView txtDescription = findViewById(R.id.txtDescription);
        TextView txtPrice = findViewById(R.id.txtPrice);
        EditText edtQuantity = findViewById(R.id.edtQuantity);
        Button btnAddCart = findViewById(R.id.btnAddCart);
        Button btnBack = findViewById(R.id.btnBack);

        Product product = (Product) getIntent().getSerializableExtra("product");

        if(product != null){
            imgProduct.setImageResource(product.getImageResourceId());
            txtName.setText(product.getName());
            txtDescription.setText(product.getDescription());
            txtPrice.setText(product.getFormattedPrice());
        }

        btnBack.setOnClickListener(v -> finish());

        btnAddCart.setOnClickListener(v ->
                Toast.makeText(this, "Added to cart!", Toast.LENGTH_SHORT).show()
        );
    }
}
