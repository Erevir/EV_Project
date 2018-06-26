package ro.siit.java10.evproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.java10.evproject.Repository.DealershipDAO;
import ro.siit.java10.evproject.Repository.VehicleDAO;
import ro.siit.java10.evproject.domain.Dealership;
import ro.siit.java10.evproject.domain.User;
import ro.siit.java10.evproject.domain.Vehicles;
import ro.siit.java10.evproject.exceptions.NotFoundException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class VehicleServiceImp implements VehiclesService {

    @Autowired
    private VehicleDAO vehicleDAO;
    @Autowired
    private DealershipDAO dealershipDAO;

//    private List<Vehicles> vehicles = new ArrayList<>();
//
//    private List<Dealership>dealerships = new ArrayList<>();

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


//    @Override
//    public Vehicles createVehicles(Vehicles vehicleToCreate) {
//
//        Optional<Dealership> dealership = dealershipDAO.findById(vehicles.getDealership().getId());
//        if (!dealership.isPresent()) {
//            throw new NotFoundException("Can not create Vehicle, dealership is invalid: " +
//                    vehicles.getDealership().getDealershipName());
//        }
//        vehicleToCreate.getDealership(dealership.get());// nu merge aici
//        Vehicles createVehicle = vehicleDAO.save(vehicleToCreate);
//        return createVehicle;
//    }


    @Override
    public void deleteVehicles(Long vinCode) {
        Optional<Vehicles> vehicles = vehicleDAO.findById(vinCode);
        if (!vehicles.isPresent()) throw new NotFoundException("Vehicle with id " + vinCode + " does not exist");
        vehicleDAO.deleteById(vinCode);
    }

}
