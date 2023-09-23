package com.example.rigmaker.model;

public class Storage {
    String brandName;
    String modelName;
    String type;
    String size;
    double price;

    public Storage(String brandName, String modelName, String type, String size, double price) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.type = type;
        this.size = size;
        this.price = price;
    }

    public Storage(){

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
