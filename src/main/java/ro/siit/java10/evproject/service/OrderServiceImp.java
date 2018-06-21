package ro.siit.java10.evproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.java10.evproject.dao_Repository.*;
import ro.siit.java10.evproject.domain.Order;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderItemDAO orderItemDAO;
    private VehicleDAO vehicleDAO;
    private UserDao userDao;
    private DealershipDAO dealershipDAO;
    private GreenBonusDAO greenBonusDAO;


    List<Order>orders = new ArrayList<>();

    public OrderServiceImp(OrderItemDAO orderItemDAO, VehicleDAO vehicleDAO, UserDao userDao,
                           DealershipDAO dealershipDAO, GreenBonusDAO greenBonusDAO) {
        this.orderItemDAO = orderItemDAO;
        this.vehicleDAO = vehicleDAO;
        this.userDao = userDao;
        this.dealershipDAO = dealershipDAO;
        this.greenBonusDAO = greenBonusDAO;
    }

    @Override
    public List<Order> getAll() {
        return orders;
    }

    @Override
    public void createOrder(String id) {

    }

    @Override
    public void deleteOrder(String id) {

    }
}
