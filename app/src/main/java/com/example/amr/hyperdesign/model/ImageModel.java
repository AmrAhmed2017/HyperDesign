package com.example.amr.hyperdesign.model;

public class ImageModel {

    private int width, height;
    private String url;

    public ImageModel(int width, int height, String url) {
        this.width = width;
        this.height = height;
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getUrl() {
        return url;
    }
}
