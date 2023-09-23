package com.example.rigmaker.model;

public class Ram {
    String brandName;
    String modelName;
    String speed;
    String size;
    double price;

    public Ram(String brandName, String modelName, String speed, String size, double price) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.speed = speed;
        this.size = size;
        this.price = price;
    }

    public Ram(){

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

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
