package ro.siit.java10.evproject.service;

import org.springframework.stereotype.Service;
import ro.siit.java10.evproject.domain.Vehicles;

import java.util.List;


@Service
public interface VehiclesService {

    //perform database transactions through the vehicles DAO

    public List<Vehicles> getVehicles();

    public Vehicles getVehicles(String vinCode);

    public void createVehicles(Vehicles vehicles);

    public void updateVehicles(Vehicles vehicles, String vinCode);

    public void deleteVehicles(String vinCode);


    }
