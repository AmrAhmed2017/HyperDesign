package com.example.amr.hyperdesign.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.amr.hyperdesign.R;
import com.example.amr.hyperdesign.controller.SampleViewHolders;
import com.example.amr.hyperdesign.model.ProductModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SampleRecyclerViewAdapter extends RecyclerView.Adapter<SampleViewHolders> {
    private ArrayList<ProductModel> productModels;
    private Context context;

    public SampleRecyclerViewAdapter(Context context,
                                     ArrayList<ProductModel> productModels) {
        this.productModels = productModels;
        this.context = context;
    }

    @Override
    public SampleViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.grid_item, null);
        SampleViewHolders rcv = new SampleViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(SampleViewHolders holder, int position) {

        holder.descTextView.setText(productModels.get(position).getProductDescription());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(productModels.get(position).getImage().getWidth()
                , productModels.get(position).getImage().getHeight());
        holder.imageView.setLayoutParams(layoutParams);
        Picasso.with(context).load(productModels.get(position).getImage().getUrl()).into(holder.imageView);
        holder.priceTextView.setText(productModels.get(position).getPrice());


    }

    @Override
    public int getItemCount() {
        return this.productModels.size();
    }
}