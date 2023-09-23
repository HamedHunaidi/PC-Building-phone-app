package com.example.rigmaker.model;

public class Gpu {
    String brandName;
    String modelName;
    String vram;
    double clearance;
    String Speed;
    double price;

    public Gpu(String brandName, String modelName, String vram, double clearance, String speed, double price) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.vram = vram;
        this.clearance = clearance;
        Speed = speed;
        this.price = price;
    }

    public Gpu(){

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

    public String getVram() {
        return vram;
    }

    public void setVram(String vram) {
        this.vram = vram;
    }

    public double getClearance() {
        return clearance;
    }

    public void setClearance(double clearance) {
        this.clearance = clearance;
    }

    public String getSpeed() {
        return Speed;
    }

    public void setSpeed(String speed) {
        Speed = speed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
