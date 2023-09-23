package com.example.rigmaker.model;

public class CpuCooler {
    String brandName;
    String modelName;
    double clearance;
    double price;

    public CpuCooler(String brandName, String modelName, double clearance, double price) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.clearance = clearance;
        this.price = price;
    }

    public CpuCooler(){

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

    public double getClearance() {
        return clearance;
    }

    public void setClearance(double clearance) {
        this.clearance = clearance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
