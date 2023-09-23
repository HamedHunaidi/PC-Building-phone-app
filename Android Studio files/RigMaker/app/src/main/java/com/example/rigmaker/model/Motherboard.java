package com.example.rigmaker.model;

public class Motherboard {
    String brandName;
    String modelName;
    String socket;
    String formFactor;
    double price;

    public Motherboard(String brandName, String modelName, String socket, String formFactor, double price) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.socket = socket;
        this.formFactor = formFactor;
        this.price = price;
    }
    public Motherboard(){

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

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
