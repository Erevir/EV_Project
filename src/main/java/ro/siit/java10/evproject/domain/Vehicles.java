package ro.siit.java10.evproject.domain;

import ro.siit.java10.evproject.domain.enumeration.FuelType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Vehicles")

public class Vehicles implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "vincode")
    private long vinCode;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "model")
    private String model;

    @Column(name = "firstReg")
    private String firstReg;

    @Column(name = "powerEngine")
    private String powerEngine;

    @Column(name = "isUsedVehicle")
    private boolean isUsedVehicle;

    @Column(name = "rangePerCharge")
    private int rangePerCharge;

    @Column(name = "fastCharging")
    private boolean fastCharging;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "fuelType", nullable=false)
    private FuelType fuelType;

    @Column(name = "price")
    private int price;

//    @Column(name="quantity")
//    public int quantity;

    @ManyToOne
    Dealership dealership;

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

    public long getVinCode() {
        return vinCode;
    }

    public Vehicles setVinCode(long vinCode) {
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

    public FuelType getFuelType() {
        return fuelType;
    }

    public Vehicles setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    public Dealership getDealership() {
        return dealership;
    }

    public Vehicles setDealership() {
        this.dealership = dealership;
        return this;
    }

    /**
 *    in case vehicle with same specification, but uniquie vinCode
 */
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public Vehicles setQuantity(int quantity) {
//        this.quantity = quantity;
//        return this;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicles)) return false;
        Vehicles vehicles = (Vehicles) o;
        return isUsedVehicle() == vehicles.isUsedVehicle() && getRangePerCharge() == vehicles.getRangePerCharge() && isFastCharging() == vehicles.isFastCharging() && getPrice() == vehicles.getPrice() && Objects.equals(getVinCode(), vehicles.getVinCode()) && Objects.equals(getManufacturer(), vehicles.getManufacturer()) && Objects.equals(getModel(), vehicles.getModel()) && Objects.equals(getFirstReg(), vehicles.getFirstReg()) && Objects.equals(getPowerEngine(), vehicles.getPowerEngine()) && Objects.equals(getFuelType(), vehicles.getFuelType());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getVinCode(), getManufacturer(), getModel(), getFirstReg(), getPowerEngine(), isUsedVehicle(), getRangePerCharge(), isFastCharging(), getFuelType(), getPrice());
    }

    @Override
    public String toString() {
        return "Vehicles{" + "manufacturer='" + manufacturer + '\'' + ", model='" + model + '\'' + ", firstReg='" + firstReg + '\'' + ", powerEngine='" + powerEngine + '\'' + ", isUsedVehicle=" + isUsedVehicle + ", rangePerCharge=" + rangePerCharge + ", fastCharging=" + fastCharging + ", fuelType='" + fuelType + '\'' + ", vinCode='" + vinCode + '\'' + ", price=" + price + '}';
    }


}
