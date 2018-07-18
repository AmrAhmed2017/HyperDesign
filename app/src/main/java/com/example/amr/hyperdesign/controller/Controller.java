package com.example.amr.hyperdesign.controller;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.amr.hyperdesign.R;
import com.example.amr.hyperdesign.adapter.SampleRecyclerViewAdapter;
import com.example.amr.hyperdesign.api.API;
import com.example.amr.hyperdesign.model.ProductModel;
import com.example.amr.hyperdesign.view.MainActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller {


    private StaggeredGridLayoutManager _sGridLayoutManager;
    private View view;

    public Controller(View view) {
        this.view = view;
    }


    public void getProduct() {


        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build();

        API api = retrofit.create(API.class);
        Call<ArrayList<ProductModel>> call = api.getProduct();
        call.enqueue(new Callback<ArrayList<ProductModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ProductModel>> call, Response<ArrayList<ProductModel>> response) {

                RecyclerView recyclerView = (RecyclerView) view;
//                 recyclerView.setHasFixedSize(true);

                _sGridLayoutManager = new StaggeredGridLayoutManager(2,
                        StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(_sGridLayoutManager);


                SampleRecyclerViewAdapter rcAdapter = new SampleRecyclerViewAdapter(
                        view.getContext(), response.body());
                recyclerView.setAdapter(rcAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<ProductModel>> call, Throwable t) {

                Toast.makeText(view.getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
