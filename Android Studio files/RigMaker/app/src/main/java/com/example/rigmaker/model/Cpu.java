package com.example.rigmaker.model;

public class Cpu {
    String brandName;
    String modelName;
    String socket;
    String clockSpeed;
    String numberOfCores;
    double price;

    public Cpu(String brandName, String modelName, String socket, String clockSpeed, String numberOfCores, double price) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.socket = socket;
        this.clockSpeed = clockSpeed;
        this.numberOfCores = numberOfCores;
        this.price = price;
    }

    public Cpu(){

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

    public String getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(String clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public String getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(String numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
