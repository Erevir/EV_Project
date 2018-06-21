package ro.siit.java10.evproject.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Vehicle")

public class Vehicles implements Serializable {
    private static final long serialVersionUID = 1L;

        @Id
        @Column(name="vincode")
        private String vinCode;

        @Column(name="manufacturer")
        private String manufacturer;

        @Column(name="model")
        private String model;

        @Column(name="firstreg")
        private String firstReg;

        @Column(name="powerengine")
        private String powerEngine;

        @Column(name = "isusedvehicle")
        private boolean isUsedVehicle;

        @Column(name="rangepercharge")
        private int rangePerCharge;

        @Column(name="isfastcharge")
        private boolean fastCharging;

        @Column(name="fueltype")
        private String fuelType;

        @Column(name="price")
        private int price;

//        @Column(name="dealership_name")
//        private Dealership dealership;


////        @ManyToMany
//        private Dealership dealership_name;

        public Vehicles(){

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicles)) return false;
        Vehicles vehicles = (Vehicles) o;
        return isUsedVehicle() == vehicles.isUsedVehicle() && getRangePerCharge() ==
                vehicles.getRangePerCharge() && isFastCharging() == vehicles.isFastCharging() && getPrice() ==
                vehicles.getPrice() && Objects.equals(getVinCode(), vehicles.getVinCode()) && Objects.equals(getManufacturer(),
                vehicles.getManufacturer()) && Objects.equals(getModel(), vehicles.getModel()) && Objects.equals(getFirstReg(),
                vehicles.getFirstReg()) && Objects.equals(getPowerEngine(), vehicles.getPowerEngine()) && Objects.equals(getFuelType(),
                vehicles.getFuelType());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getVinCode(), getManufacturer(), getModel(), getFirstReg(), getPowerEngine(),
                isUsedVehicle(), getRangePerCharge(), isFastCharging(), getFuelType(), getPrice());
    }

    @Override
    public String toString() {
        return "Vehicles{" + "manufacturer='" + manufacturer + '\''
                + ", model='" + model + '\'' + ", firstReg='" + firstReg + '\''
                + ", powerEngine='" + powerEngine + '\'' + ", isUsedVehicle=" + isUsedVehicle
                + ", rangePerCharge=" + rangePerCharge + ", fastCharging=" + fastCharging
                + ", fuelType='" + fuelType + '\'' + ", vinCode='" + vinCode + '\'' + ", price=" + price + '}';
    }


}
