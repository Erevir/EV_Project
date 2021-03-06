package ro.siit.java10.evproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.java10.evproject.Repository.*;
import ro.siit.java10.evproject.domain.*;
import ro.siit.java10.evproject.domain.enumeration.OrderStatus;
import ro.siit.java10.evproject.exceptions.NotFoundException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    private VehicleDAO vehicleDAO;
    private UserDao userDao;
    private GreenBonusDAO greenBonusDAO;
    private OrderItem orderItem;
    private User user;

    @Override
    public List<Order> getAll() {
        return orderDAO.findAll();
    }

    @Override
    public Order getById(Long id) {
        Optional<Order> order = orderDAO.findById(id);
        if (!order.isPresent()) throw new NotFoundException("Order with id " + id + " does not exist");
        return order.get();
    }

    @Override
    public Order createOrder(Order orderToCreate) {
        Order createOrder = orderDAO.save(orderToCreate);
        orderDAO.save(orderToCreate.date(orderToCreate.getDate()).status(OrderStatus.NEW));
    return orderToCreate;
    }

    @Override
    public void deleteOrder(Long id) {
        Optional<Order> order = orderDAO.findById(id);
        if (!order.isPresent()) throw new NotFoundException("Order with id " + id + " does not exist");
        orderDAO.deleteById(id);
    }

    public Order submitOrder(Order order) {

        for (OrderItem item : order.getOrderItems()) {
            Vehicles vehicles = vehicleDAO.getOne(item.getVehicles().getVinCode());
//                TODO existing vehicle orderItem
//             ***comment code for case vehicle with same specification, but uniquie vinCode***
//                Optional<Vehicles> vehicles = vehicleDAO.findById(item.getVehicles().getVinCode());
//                if (!vehicles.isPresent()) throw new NotFoundException("Vehicle with id " + vinCode + " does not exist");
//                if (vehicles.getQuantity() < item.getQuantity()) return null;
//                item.setVehicles(vehicles.quantity(vehicles.getQuantity() - item.getQuantity()));
            if (order.getTotalPrice() > order.getUser().getCustomerFunds())
                throw new NotFoundException("User with does not have enough to buy the vehicle");
            order.setTotalPrice(order.getTotalPrice() + (vehicles.getPrice() * item.getQuantity()));
            vehicleDAO.save(vehicles);
        }
        if (order.getGreenBonus() != null) {
            GreenBonus greenBonus = greenBonusDAO.getOne(order.getGreenBonus().getId());
            if (!orderItem.isGreenBonusValid()) return null;
            greenBonus.useBonus();
            order.setGreenBonus(greenBonusDAO.save(greenBonus));
            long normalPrice = order.getTotalPrice();
            long totalPrice = normalPrice - greenBonus.getAmount();
            order.setTotalPrice(totalPrice);
        }
        return orderDAO.save(order.date(order.getDate()).status(OrderStatus.PENDING));
    }

    public Order rejectOrder(Order order) {
        // return vehicles and bonus quantity
        for (OrderItem item : order.getOrderItems()) {
            Vehicles vehicles = vehicleDAO.getOne(item.getVehicles().getVinCode());
//              vehicles.addQuantity(item.getQuantity());
            item.setVehicles(vehicleDAO.save(vehicles));
        }
        if (order.getGreenBonus() != null) {
            GreenBonus greenBonus = greenBonusDAO.getOne(order.getGreenBonus().getId());
            greenBonus.addQuantity();
            order.setGreenBonus(greenBonusDAO.save(greenBonus));
        }
        return orderDAO.save(order.status(OrderStatus.CANCELLED));
    }

//   public Order orderTransaction(Order order){
//        TODO transaction order metod
//
//
//
//   }

}
