package com.example.ict372;

import android.content.Context;
import android.content.Intent;

public class NavigationManager {

    // function to link intent to home

    /*    The following pattern can be used to link views and buttons using the functions established below
    *
    * btnLogin.setOnClickListener(v -> {
    * NavigationManager.goToHome(LoginAct.this);
    * });
    *
    * tvRegister.setOnClickListener(v -> {
    * NavigationManager.goToRegister(LoginAct.this);
    * });
    *
    *
    *
    *
    * */



    public static void goToHome(Context context){
        Intent intent = new Intent(context, HomeAct.class);
        context.startActivity(intent);

    }

    public static void goToRegister(Context context){
        Intent intent = new Intent(context, RegAct.class);
        context.startActivity(intent);
    }


    //Allows for clicking an item in the search results, will give access to the item details page
    public static void goToDetails(Context context, String productName){
        Intent intent = new Intent(context, ProductDetailsAct.class);
        intent.putExtra("PRODUCT_NAME", productName);
        context.startActivity(intent);
    }

    public static void goToOrdHistory(Context context){
        Intent intent = new Intent(context, OrdHistoryAct.class);
        context.startActivity(intent);
    }

    public static void goToMain(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public static void goToSearch(Context context){
        Intent intent = new Intent(context, SearchAct.class);
        context.startActivity(intent);
    }

    public static void goToLogin(Context context){
        Intent intent = new Intent(context, LoginAct.class);
        context.startActivity(intent);
    }

    public static void goToCart(Context context){
        Intent intent = new Intent(context, CartAct.class);
        context.startActivity(intent);
    }

    public static void goToCheckout(Context context){
        Intent intent = new Intent(context, CheckoutAct.class);
        context.startActivity(intent);
    }


}
