package ro.siit.java10.evproject.service;

import org.springframework.stereotype.Service;
import ro.siit.java10.evproject.domain.Vehicles;

import java.util.ArrayList;
import java.util.List;

public class VehicleServiceImp implements VehiclesService {

    private List<Vehicles>vehicles = new ArrayList<>();

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

//    @Service
//    public class ProductServiceImpl implements ProductService {
//
//        //inject product DAO
//        @Autowired
//        private ProductDAO productDAO;
//
//        @Override
//        @Transactional
//        public List<Product> getProducts() {
//
//            return productDAO.getProducts();
//        }
//
//        @Override
//        @Transactional
//        public Product getProduct(int theId) {
//
//            return productDAO.getProduct(theId);
//        }
//
//    }
//    private List<Vehicles>vehicles = new ArrayList<>();
//
//    @Override
//    public List<Vehicles> getAll() {
//        return vehicles;
//    }
//
//    @Override
//    public void createVehicle() {
//          vehicles.add((Vehicles) vehicles);// why cast???  GENERICS
//
//    }
}
