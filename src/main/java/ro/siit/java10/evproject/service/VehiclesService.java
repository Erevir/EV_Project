package ro.siit.java10.evproject.service;

import org.springframework.stereotype.Service;
import ro.siit.java10.evproject.domain.Vehicles;

import java.util.List;



public interface VehiclesService {

    //perform database transactions through the vehicles DAO

    public List<Vehicles> getAllVehicles();

    public Vehicles getById(Long vinCode);

//    Vehicles createVehicles(Vehicles vehicles);

    //public void updateVehicles(Vehicles vehicles, String vinCode);

    void deleteVehicles(Long vinCode);


    }
