package com.example.rigmaker.model;

public class Case {
    String brandName;
    String modelName;
    String formFactor;
    double gpuClearance;
    double cpuCoolerClearance;
    String psuFormFactor;
    String motherboardFormFactor;
    double price;

    public Case(String brandName, String modelName, String formFactor, double gpuClearance, double cpuCoolerClearance, String psuFormFactor, String motherboardFormFactor, double price) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.formFactor = formFactor;
        this.gpuClearance = gpuClearance;
        this.cpuCoolerClearance = cpuCoolerClearance;
        this.psuFormFactor = psuFormFactor;
        this.motherboardFormFactor = motherboardFormFactor;
        this.price = price;
    }

    public Case(){

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

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public double getGpuClearance() {
        return gpuClearance;
    }

    public void setGpuClearance(double gpuClearance) {
        this.gpuClearance = gpuClearance;
    }

    public double getCpuCoolerClearance() {
        return cpuCoolerClearance;
    }

    public void setCpuCoolerClearance(double cpuCoolerClearance) {
        this.cpuCoolerClearance = cpuCoolerClearance;
    }

    public String getPsuFormFactor() {
        return psuFormFactor;
    }

    public void setPsuFormFactor(String psuFormFactor) {
        this.psuFormFactor = psuFormFactor;
    }

    public String getMotherboardFormFactor() {
        return motherboardFormFactor;
    }

    public void setMotherboardFormFactor(String motherboardFormFactor) {
        this.motherboardFormFactor = motherboardFormFactor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
