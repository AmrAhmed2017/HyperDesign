package com.example.amr.hyperdesign.view;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.amr.hyperdesign.R;
import com.example.amr.hyperdesign.controller.Controller;

public class MainActivity extends AppCompatActivity {

    private Controller controller;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = this.findViewById(R.id.recycler_view);
        controller = new Controller(view);
        if (isNetworkAvailable())
            controller.getProduct();
        else
            Toast.makeText(this, "Check your internet connection", Toast.LENGTH_SHORT).show();

        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (isNetworkAvailable()) {
                    controller.getProduct();
                    swipeRefreshLayout.setRefreshing(false);
                } else {

                    Toast.makeText(MainActivity.this, "Check your internet connection", Toast.LENGTH_SHORT).show();
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        });

    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectMgr.getActiveNetworkInfo();
        return (activeNetworkInfo != null && activeNetworkInfo.isConnected());
    }
}