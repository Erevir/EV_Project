package ro.siit.java10.evproject.service;

import ro.siit.java10.evproject.domain.Vehicles;

import java.util.List;

public interface VehiclesService {

    //perform database transactions through the vehicles DAO

    public List<Vehicles> getVehicles();

    public Vehicles getVehicles(String vinCode);

    public void createVehicles(Vehicles vehicles);

    public void updateVehicles(Vehicles vehicles, String vinCode);

    public void deleteVehicles(String vinCode);


//    public List<Product> getProducts();
//
//    public Product getProduct(int theId);
//    public interface CustomerService {
//
//        public List<Customer> getCustomers();
//
//        public void saveCustomer(Customer theCustomer);
//
//        public Customer getCustomer(int theId);
//
//        public void deleteCustomer(int theId);
//
//        public List<Product> getProducts(int theId);
//
//        public void addProduct(int productId, int customerId);
//
//        public void removeProduct(int productId, int customerId);
//
//        public void updateCustomer(Customer theCustomer);
//
//    }
    }
