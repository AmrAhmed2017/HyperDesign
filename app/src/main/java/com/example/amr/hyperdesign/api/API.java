package com.example.amr.hyperdesign.api;

import com.example.amr.hyperdesign.model.ProductModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {


    String BASE_URL = "http://grapesnberries.getsandbox.com/";

    @GET("products?count=10&from=1")
    Call<ArrayList<ProductModel>> getProduct();
}
