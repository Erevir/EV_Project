package ro.siit.java10.evproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.siit.java10.evproject.domain.Vehicles;
import ro.siit.java10.evproject.service.VehicleServiceImp;
import java.util.List;

/**
 * REST controller for managing Vehicle.
 */

@RestController
@RequestMapping
public class VehicleController {

    @Autowired
    private VehicleServiceImp vehicleServiceImp;


    @RequestMapping(value = "/vehicles/all", method = RequestMethod.GET)
    public List<Vehicles> listVehicles() {
        return vehicleServiceImp.getAllVehicles();
    }

    @RequestMapping(value = "/vehicles/sortedByPrice", method = RequestMethod.GET)
    public List<Vehicles> listVehiclesSortedByPrice() {
        return vehicleServiceImp.getVehiclesSortedByPrice();
    }

    @RequestMapping(value = "/vehicles/{vinCode}", method = RequestMethod.GET)
    public Vehicles getById(@PathVariable Long vinCode) {
        return  vehicleServiceImp.getById(vinCode);
    }

   @RequestMapping(value = "/vehicles", method = RequestMethod.POST)
    public Vehicles createVehicles(@RequestBody Vehicles vehicles) {
        return vehicleServiceImp.createVehicles(vehicles);
    }

    @RequestMapping(value = "/vehicles/delete/{vinCode}", method = RequestMethod.DELETE)
    public String deleteVehicles(@PathVariable Long vinCode) {
        vehicleServiceImp.deleteVehicles(vinCode);
        return "deleted vehicles";
    }

    @RequestMapping(value = "/vehicles/getFastCharging", method = RequestMethod.GET)
    public List<Vehicles> getFastChargingVehiclesInStock() {
        return vehicleServiceImp.getFastChargingVehiclesInStock();
    }

    @RequestMapping(value = "/vehicles/getEV", method = RequestMethod.GET)
    public List<Vehicles> getElectricVehicles() {
        return vehicleServiceImp.getElectricVehicles();
    }

    @RequestMapping(value = "/vehicles/getVehicleSortedByPowerEngine", method = RequestMethod.GET)
    public List<Vehicles> getVehiclesSortedByPowerEngine() {
        return vehicleServiceImp.getVehiclesSortedByPowerEngine();
    }
    @RequestMapping(value = "/vehicles/getVehiclesSortedByRangePerCharge", method = RequestMethod.GET)
    public List<Vehicles> getVehiclesSortedByRangePerCharge() {
        return vehicleServiceImp.getVehiclesSortedByRangePerCharge();
    }
}