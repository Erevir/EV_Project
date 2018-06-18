package ro.siit.java10.evproject.dto;

public class CreateVehiclesReguest {

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

    public String getManufacturer() {
        return manufacturer;
    }

    public CreateVehiclesReguest setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CreateVehiclesReguest setModel(String model) {
        this.model = model;
        return this;
    }

    public String getFirstReg() {
        return firstReg;
    }

    public CreateVehiclesReguest setFirstReg(String firstReg) {
        this.firstReg = firstReg;
        return this;
    }

    public String getPowerEngine() {
        return powerEngine;
    }

    public CreateVehiclesReguest setPowerEngine(String powerEngine) {
        this.powerEngine = powerEngine;
        return this;
    }

    public boolean isUsedVehicle() {
        return isUsedVehicle;
    }

    public CreateVehiclesReguest setUsedVehicle(boolean usedVehicle) {
        isUsedVehicle = usedVehicle;
        return this;
    }

    public int getRangePerCharge() {
        return rangePerCharge;
    }

    public CreateVehiclesReguest setRangePerCharge(int rangePerCharge) {
        this.rangePerCharge = rangePerCharge;
        return this;
    }

    public boolean isFastCharging() {
        return fastCharging;
    }

    public CreateVehiclesReguest setFastCharging(boolean fastCharging) {
        this.fastCharging = fastCharging;
        return this;
    }

    public String getFuelType() {
        return fuelType;
    }

    public CreateVehiclesReguest setFuelType(String fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    public String getVinCode() {
        return vinCode;
    }

    public CreateVehiclesReguest setVinCode(String vinCode) {
        this.vinCode = vinCode;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public CreateVehiclesReguest setPrice(int price) {
        this.price = price;
        return this;
    }
}
