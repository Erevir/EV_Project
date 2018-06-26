package ro.siit.java10.evproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.siit.java10.evproject.Repository.DealershipDAO;
import ro.siit.java10.evproject.domain.Vehicles;
import ro.siit.java10.evproject.service.DealershipServiceImp;
import ro.siit.java10.evproject.service.VehicleServiceImp;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    private VehicleServiceImp vehicleServiceImp;
    @Autowired
    DealershipServiceImp dealershipServiceImp;


    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    public List<Vehicles> listVehicles() {
        return vehicleServiceImp.getAllVehicles();
    }
    @RequestMapping(value = "/vehicles/{vinCode}", method = RequestMethod.GET)
    public Vehicles getById(@PathVariable Long vinCode) {
        Vehicles vehicles = vehicleServiceImp.getById(vinCode);
        return vehicles;
    }

////    @RequestMapping(value = "/vehicles", method = RequestMethod.POST)
////    public Vehicles createVehicles(@RequestBody Vehicles vehicles) {
////        Vehicles createdVehicle = vehicleServiceImp.createVehicle(vehicles);
////        return createdVehicle;
//    }

    @RequestMapping(value = "/vehicles/delete/{vinCode}", method = RequestMethod.DELETE)
    public String deleteVehicles(@PathVariable Long vinCode) {
        vehicleServiceImp.deleteVehicles(vinCode);
        return "deleted vehicles";
    }
}