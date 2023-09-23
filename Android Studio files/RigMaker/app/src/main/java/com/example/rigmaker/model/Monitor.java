package com.example.rigmaker.model;

public class Monitor {
    String brandName;
    String modelName;
    String screenSize;
    String panel;
    String resolution;
    String refreshRate;
    double price;

    public Monitor(String brandName, String modelName, String screenSize, String panel, String resolution, String refreshRate, double price) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.screenSize = screenSize;
        this.panel = panel;
        this.resolution = resolution;
        this.refreshRate = refreshRate;
        this.price = price;
    }

    public Monitor(){

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

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getPanel() {
        return panel;
    }

    public void setPanel(String panel) {
        this.panel = panel;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(String refreshRate) {
        this.refreshRate = refreshRate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
