package com.example.amr.hyperdesign.controller;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amr.hyperdesign.R;

public class SampleViewHolders extends RecyclerView.ViewHolder implements
        View.OnClickListener {

    public TextView priceTextView;
    public TextView descTextView;
    public ImageView imageView;

    public SampleViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        priceTextView = itemView.findViewById(R.id.price_view);
        descTextView = itemView.findViewById(R.id.desc_view);
        imageView = itemView.findViewById(R.id.image_view);
    }

    @Override
    public void onClick(View view) {

        Dialog dialog = new Dialog(view.getContext());
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(View.inflate(view.getContext(), R.layout.pop_up, null));
        ImageView popImageView = dialog.findViewById(R.id.popup_image);
        popImageView.setImageDrawable(imageView.getDrawable());

        dialog.show();


    }
}
