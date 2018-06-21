package ro.siit.java10.evproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.java10.evproject.dao_Repository.GreenBonusDAO;
import ro.siit.java10.evproject.dao_Repository.OrderDAO;
import ro.siit.java10.evproject.dao_Repository.UserDao;
import ro.siit.java10.evproject.dao_Repository.VehicleDAO;
import ro.siit.java10.evproject.domain.Dealership;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class DealershipServiceImp implements DealershipService {

    @Autowired
    private VehicleDAO vehicleDAO;
    private UserDao userDao;
    private GreenBonusDAO greenBonusDAO;
    private OrderDAO orderDAO;

private List<Dealership> dealerships = new ArrayList<>();

    public DealershipServiceImp(VehicleDAO vehicleDAO, UserDao userDao, GreenBonusDAO greenBonusDAO, OrderDAO orderDAO) {
        this.vehicleDAO = vehicleDAO;
        this.userDao = userDao;
        this.greenBonusDAO = greenBonusDAO;
        this.orderDAO = orderDAO;
    }


    @Override
    public List<Dealership> getAll() {
        return dealerships;
    }

    @Override
    public void createDealership(Dealership dealership) {

    }

    @Override
    public void updateDealership(Dealership dealership, String dealerShipName) {

    }

    @Override
    public void deleteDealership(String dealerShipName) {

    }

    @Override
    public Dealership getByName(String dealerShipName) {
        //TODO check that the id exists
        return dealerships.stream().filter(c -> c.getDealerShipName() == dealerShipName).collect(Collectors.toList()).get(0);
    }
}
