package com.example.rigmaker.model;

public class Rig {
    String name;
    double price;
    String tier;
    Cpu cpu;
    Case pcCase;
    CpuCooler cpuCooler;
    Gpu gpu;
    Monitor monitor;
    Motherboard motherbaord;
    PowerSupply powerSupply;
    Ram ram;
    Storage storgage;
    Boolean isSuggested;
    Boolean isCommunity;
    String buildAuthor;

    public Rig(String name, double price, String tier, Cpu cpu, Case pcCase, CpuCooler cpuCooler, Gpu gpu, Monitor monitor, Motherboard motherbaord, PowerSupply powerSupply, Ram ram, Storage storgage, Boolean isSuggested, Boolean isCommunity, String buildAuthor) {
        this.name = name;
        this.price = price;
        this.tier = tier;
        this.cpu = cpu;
        this.pcCase = pcCase;
        this.cpuCooler = cpuCooler;
        this.gpu = gpu;
        this.monitor = monitor;
        this.motherbaord = motherbaord;
        this.powerSupply = powerSupply;
        this.ram = ram;
        this.storgage = storgage;
        this.isSuggested = isSuggested;
        this.isCommunity = isCommunity;
        this.buildAuthor = buildAuthor;
    }
    public Rig(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Case getPcCase() {
        return pcCase;
    }

    public void setPcCase(Case pcCase) {
        this.pcCase = pcCase;
    }

    public CpuCooler getCpuCooler() {
        return cpuCooler;
    }

    public void setCpuCooler(CpuCooler cpuCooler) {
        this.cpuCooler = cpuCooler;
    }

    public Gpu getGpu() {
        return gpu;
    }

    public void setGpu(Gpu gpu) {
        this.gpu = gpu;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Motherboard getMotherbaord() {
        return motherbaord;
    }

    public void setMotherbaord(Motherboard motherbaord) {
        this.motherbaord = motherbaord;
    }

    public PowerSupply getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Storage getStorgage() {
        return storgage;
    }

    public void setStorgage(Storage storgage) {
        this.storgage = storgage;
    }

    public Boolean getSuggested() {
        return isSuggested;
    }

    public void setSuggested(Boolean suggested) {
        isSuggested = suggested;
    }

    public Boolean getCommunity() {
        return isCommunity;
    }

    public void setCommunity(Boolean community) {
        isCommunity = community;
    }

    public String getBuildAuthor() {
        return buildAuthor;
    }

    public void setBuildAuthor(String buildAuthor) {
        this.buildAuthor = buildAuthor;
    }
}
