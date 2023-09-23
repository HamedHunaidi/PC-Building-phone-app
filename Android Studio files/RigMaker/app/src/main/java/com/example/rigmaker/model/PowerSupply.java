package com.example.rigmaker.model;

public class PowerSupply {
    String brandName;
    String modelName;
    String wattage;
    String formFactor;
    String rating;
    double price;

    public PowerSupply(String brandName, String modelName, String wattage, String formFactor, String rating, double price) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.wattage = wattage;
        this.formFactor = formFactor;
        this.rating = rating;
        this.price = price;
    }

    public PowerSupply(){

    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getWattage() {
        return wattage;
    }

    public void setWattage(String wattage) {
        this.wattage = wattage;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
