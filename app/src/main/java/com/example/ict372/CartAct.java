package com.example.ict372;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        List<String> tempItems = new ArrayList<>();
        tempItems.add("Product A");
        tempItems.add("Product B");

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);

        RecyclerView rv = findViewById(R.id.cartRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        List<String> fakeData = new ArrayList<>();
        fakeData.add("Item 1: Pizza");
        fakeData.add("Item 2: Burger");
        fakeData.add("Item 3: Soda");

        CartAdapter adapter = new CartAdapter(fakeData);
        rv.setAdapter(adapter);





    }
}