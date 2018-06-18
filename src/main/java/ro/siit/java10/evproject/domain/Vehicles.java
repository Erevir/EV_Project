package ro.siit.java10.evproject.domain;


import java.util.Objects;

public class Vehicles {

    private String manufacturer;
    private String model;
    private String firstReg;
    private String powerEngine;
    private boolean isUsedVehicle;
    private int rangePerCharge;
    private boolean fastCharging;
    private String fuelType;
    private String vinCode;
    private int price;

    public Vehicles(){

    }

    public Vehicles(String manufacturer, String model, String firstReg, String powerEngine,
                    boolean isUsedVehicle, int rangePerCharge,boolean fastCharging, String fuelType,
                    String vinCode, int price) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.firstReg=firstReg;
        this.powerEngine = powerEngine;
        this.isUsedVehicle = isUsedVehicle;
        this.rangePerCharge = rangePerCharge;
        this.fastCharging = fastCharging;
        this.fuelType = fuelType;
        this.vinCode = vinCode;
        this.price = price;
    }
    public String getManufacturer() {
        return manufacturer;
    }

    public Vehicles setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Vehicles setModel(String model) {
        this.model = model;
        return this;
    }

    public String getFirstReg() {
        return firstReg;
    }

    public Vehicles setFirstReg(String firstReg) {
        this.firstReg = firstReg;
        return this;
    }

    public String getPowerEngine() {
        return powerEngine;
    }

    public Vehicles setPowerEngine(String powerEngine) {
        this.powerEngine = powerEngine;
        return this;
    }

    public String getVinCode() {
        return vinCode;
    }

    public Vehicles setVinCode(String vinCode) {
        this.vinCode = vinCode;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Vehicles setPrice(int price) {
        this.price = price;
        return this;
    }

    public boolean isUsedVehicle() {
        return isUsedVehicle;
    }

    public Vehicles setUsedVehicle(boolean usedVehicle) {
        isUsedVehicle = usedVehicle;
        return this;
    }

    public int getRangePerCharge() {
        return rangePerCharge;
    }

    public Vehicles setRangePerCharge(int rangePerCharge) {
        this.rangePerCharge = rangePerCharge;
        return this;
    }

    public boolean isFastCharging() {
        return fastCharging;
    }

    public Vehicles setFastCharging(boolean fastCharging) {
        this.fastCharging = fastCharging;
        return this;
    }

    public String getFuelType() {
        return fuelType;
    }

    public Vehicles setFuelType(String fuelType) {
        this.fuelType = fuelType;
        return this;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Vehicles vehicles = (Vehicles) o;
//        return getPrice() == vehicles.getPrice() && isUsedVehicle() == vehicles.isUsedVehicle() && getRangePerCharge() == vehicles.getRangePerCharge() && isFastCharging() == vehicles.isFastCharging() && Objects.equals(getManufacturer(), vehicles.getManufacturer()) && Objects.equals(getModel(), vehicles.getModel()) && Objects.equals(getFirstReg(), vehicles.getFirstReg()) && Objects.equals(getPowerEngine(), vehicles.getPowerEngine()) && Objects.equals(getVinCode(), vehicles.getVinCode()) && Objects.equals(getFuelType(), vehicles.getFuelType());
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(getManufacturer(), getModel(), getFirstReg(), getPowerEngine(), getVinCode(), getPrice(), isUsedVehicle(), getRangePerCharge(), isFastCharging(), getFuelType());
//    }
    @Override
    public String toString() {
        return "Vehicles{" + "manufacturer='" + manufacturer + '\''
                + ", model='" + model + '\'' + ", firstReg='" + firstReg + '\''
                + ", powerEngine='" + powerEngine + '\'' + ", isUsedVehicle=" + isUsedVehicle
                + ", rangePerCharge=" + rangePerCharge + ", fastCharging=" + fastCharging
                + ", fuelType='" + fuelType + '\'' + ", vinCode='" + vinCode + '\'' + ", price=" + price + '}';
    }


}
