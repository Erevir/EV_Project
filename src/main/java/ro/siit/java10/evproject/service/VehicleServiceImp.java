package ro.siit.java10.evproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.java10.evproject.dao_Repository.DealershipDAO;
import ro.siit.java10.evproject.dao_Repository.VehicleDAO;
import ro.siit.java10.evproject.domain.Vehicles;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class VehicleServiceImp implements VehiclesService {

  @Autowired
   private VehicleDAO vehicleDAO;
  private DealershipDAO dealershipDAO;



    private List<Vehicles>vehicles = new ArrayList<>();

    public VehicleServiceImp(VehicleDAO vehicleDAO, DealershipDAO dealershipDAO) {
        this.vehicleDAO = vehicleDAO;
        this.dealershipDAO = dealershipDAO;
    }

    @Override
    public List<Vehicles> getVehicles() {
        return vehicles;
    }

    @Override
    public Vehicles getVehicles(String vinCode) {
        return (Vehicles) vehicles;
    }

    @Override
    public void createVehicles(Vehicles vehicles) {

    }

    @Override
    public void updateVehicles(Vehicles vehicles, String vinCode) {

    }

    @Override
    public void deleteVehicles(String vinCode) {

    }

}
