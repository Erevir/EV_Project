package ro.siit.java10.evproject.service;

import ro.siit.java10.evproject.domain.Vehicles;
import java.util.List;

public interface VehiclesService {

    //perform database transactions through the vehicles DAO

    List<Vehicles> getAllVehicles();

    Vehicles getById(Long vinCode);

    Vehicles createVehicles(Vehicles vehicles);

    void deleteVehicles(Long vinCode);

    List<Vehicles> getVehiclesSortedByPrice();

    List<Vehicles> getElectricVehicles();

    List<Vehicles> getVehiclesSortedByRangePerCharge();

    List<Vehicles> getVehiclesSortedByPowerEngine();

    List<Vehicles> getFastChargingVehiclesInStock();

    }
