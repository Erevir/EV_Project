package ro.siit.java10.evproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.siit.java10.evproject.domain.User;
import ro.siit.java10.evproject.domain.Vehicles;
import ro.siit.java10.evproject.dto.CreateUserReguest;
import ro.siit.java10.evproject.dto.CreateVehiclesReguest;
import ro.siit.java10.evproject.service.VehicleServiceImp;
import ro.siit.java10.evproject.service.VehiclesService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class VehicleController {

    @Autowired
    private VehiclesService vehiclesService;


    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    public String listVehicles(Model model, HttpServletRequest request) {
        List<Vehicles> vehicles = vehiclesService.getVehicles();
        model.addAttribute("vehicles", vehiclesService);
        model.addAttribute("createVehicleRequest", new CreateVehiclesReguest());

        return "listVehicles";
    }



    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public String createVehicles(Vehicles vehicleRequest, Model model) {
        Vehicles vehicles = getVehicle(vehicleRequest);
        vehiclesService.createVehicles(vehicles);

        return "redirect:/vehicles";
    }

    @RequestMapping(value = "/vehicles/{vinCode}", method = RequestMethod.GET)
    public String getVehicle(@PathVariable String vinCode, Model model) {
        Vehicles vehicles = vehiclesService.getVehicles(vinCode);
        model.addAttribute("updateVehiclesRequest", getVehiclesRequest(vehicles));
        model.addAttribute("vehicle_vinCode", vinCode);
        return "updateVehicles";
    }


//    @RequestMapping(value = "/vehicles/update/{vinCode}", method = RequestMethod.POST)
//    public String updateVehicles(CreateVehiclesReguest vehiclesReguest, @PathVariable String vinCode) {
//
//        Vehicles vehicles = getVehicle(vehiclesReguest);
//        vehiclesService.updateVehicles(vehicles, vinCode);
//
//        return "redirect:/vehicles";
//    }

    @RequestMapping(value = "/vehicles/delete/{vinCode}", method = RequestMethod.POST)
    public String deleteVehicles(@PathVariable String vinCode, Model model) {

        vehiclesService.deleteVehicles(vinCode);

        return "redirect:/vehicles";
    }
    private Vehicles getVehicle(Vehicles vehiclesRequest) {

        Vehicles vehicles = new Vehicles();
        vehicles.setVinCode(vehiclesRequest.getVinCode());
        vehicles.setManufacturer(vehiclesRequest.getManufacturer());
        vehicles.setModel(vehiclesRequest.getModel());
        vehicles.setFirstReg(vehiclesRequest.getFirstReg());
        vehicles.setFuelType(vehiclesRequest.getFuelType());
        vehicles.setPowerEngine(vehiclesRequest.getPowerEngine());
//        vehicles.setFastCharging(vehiclesRequest.get());
//        vehicles.setUsedVehicle(vehiclesRequest.getUsedVehicle());
        vehicles.setRangePerCharge(vehiclesRequest.getRangePerCharge());
        vehicles.setPrice(vehiclesRequest.getPrice());

        return vehicles;
    }

    private Vehicles getVehiclesRequest(Vehicles vehicles) {
        Vehicles createVehiclesRequest = new Vehicles();

        createVehiclesRequest.setVinCode(vehicles.getVinCode());
        createVehiclesRequest.setManufacturer(vehicles.getManufacturer());
        createVehiclesRequest.setModel(vehicles.getModel());
        createVehiclesRequest.setFirstReg(vehicles.getFirstReg());
        createVehiclesRequest.setPowerEngine(vehicles.getPowerEngine());
        createVehiclesRequest.setFuelType(vehicles.getFuelType());
        createVehiclesRequest.setPrice(vehicles.getPrice());
        createVehiclesRequest.setRangePerCharge(vehicles.getPrice());


        return createVehiclesRequest;

    }

}