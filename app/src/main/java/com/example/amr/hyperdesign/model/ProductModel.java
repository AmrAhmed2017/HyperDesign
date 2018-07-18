package com.example.amr.hyperdesign.model;

public class ProductModel {

    private String productDescription;
    private ImageModel image;
    private String price;

    public ProductModel(String productDescription, ImageModel image, String price) {
        this.productDescription = productDescription;
        this.image = image;
        this.price = price;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public ImageModel getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }
}
