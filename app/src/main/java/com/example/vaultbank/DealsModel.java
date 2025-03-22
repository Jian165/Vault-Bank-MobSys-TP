package com.example.vaultbank;

public class DealsModel {
    String dealTitle;

    public int getImage() {
        return image;
    }

    public String getDealTitle() {
        return dealTitle;
    }

    int image;

    public DealsModel(String dealTitle, int image) {
        this.dealTitle = dealTitle;
        this.image = image;
    }
}
