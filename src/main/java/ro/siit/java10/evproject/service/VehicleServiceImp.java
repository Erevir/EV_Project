package ro.siit.java10.evproject.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.java10.evproject.Repository.DealershipDAO;
import ro.siit.java10.evproject.Repository.VehicleDAO;
import ro.siit.java10.evproject.domain.Dealership;
import ro.siit.java10.evproject.domain.Vehicles;
import ro.siit.java10.evproject.exceptions.NotFoundException;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;


@Service
@Transactional
public class VehicleServiceImp implements VehiclesService {

    private final Logger log = LoggerFactory.getLogger(VehicleServiceImp.class);

    @Autowired
    private Vehicles vehicles;
    private VehicleDAO vehicleDAO;
    private DealershipDAO dealershipDAO;

//    private List<Vehicles> vehicles = new ArrayList<>();
    private List<Dealership>dealerships = new ArrayList<>();

    @Override
    public List<Vehicles> getAllVehicles() {

        return vehicleDAO.findAll();
    }

    @Override
    public Vehicles getById(Long vinCode) {
        Optional<Vehicles>vehicles = vehicleDAO.findById(vinCode);
        if (!vehicles.isPresent()) throw new NotFoundException("Vehicle with id " + vinCode + " does not exist");
        return vehicles.get();
    }

    @Override
    public Vehicles createVehicles(Vehicles vehicleToCreate) {

//        Optional<Dealership> dealership = dealershipDAO.findById(vehicleToCreate.getDealership().getId());
//        if (!dealership.isPresent()) {
//            throw new NotFoundException("Can not create Vehicle, dealership is invalid: " +
//                    vehicleToCreate.getDealership().getDealershipName());
//        }
//        vehicleToCreate.setDealership(dealership.get());
        Vehicles createVehicle = vehicleDAO.save(vehicleToCreate);
        log.debug("Created Information for Vehicles: {}", vehicleToCreate);
        return createVehicle;
    }


    @Override
    public void deleteVehicles(Long vinCode) {
        Optional<Vehicles> vehicles = vehicleDAO.findById(vinCode);
        if (!vehicles.isPresent()) throw new NotFoundException("Vehicle with id " + vinCode + " does not exist");
        log.debug("Deleted information for vehicle: {}", vehicleDAO);
        vehicleDAO.deleteById(vinCode);
    }

    @Override
    public List<Vehicles> getVehiclesSortedByPrice() {
        List<Vehicles> vehicles = vehicleDAO.findAll();
        vehicles.sort(Comparator.comparing(Vehicles::getPrice));
        return vehicles;
    }

    @Override
    public List<Vehicles> getElectricVehicles() {
        List<Vehicles> vehicles = vehicleDAO.findAll();
        vehicles.sort(Comparator.comparing(Vehicles::getFuelType));
        return vehicles;
    }

    @Override
    public List<Vehicles> getVehiclesSortedByRangePerCharge() {
        List<Vehicles> vehicles = vehicleDAO.findAll();
        vehicles.sort(Comparator.comparing(Vehicles::getRangePerCharge));
        return vehicles;
    }

    @Override
    public List<Vehicles> getVehiclesSortedByPowerEngine() {
        List<Vehicles> vehicles = vehicleDAO.findAll();
        vehicles.sort(Comparator.comparing(Vehicles::getPowerEngine));
        return vehicles;
    }

    @Override
    public List<Vehicles> getFastChargingVehiclesInStock() {
        List<Vehicles> vehicles = vehicleDAO.findAll();
        return  vehicles.stream().filter(x->x.isFastCharging()).collect(Collectors.toCollection(() -> new ArrayList<Vehicles>()));
    }

//    public List<Vehicles> getVehiclesByDealership() {
//        List<Vehicles> vehicles = vehicleDAO.findAll();
//        vehicles.sort(Comparator.comparing(Vehicles::()))
//        return vehicles; //TODO getVehiclesByDealership sorting
//    }
}
