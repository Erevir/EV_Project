package ro.siit.java10.evproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.siit.java10.evproject.Repository.OrderDAO;
import ro.siit.java10.evproject.domain.Order;
import ro.siit.java10.evproject.domain.OrderItem;
import ro.siit.java10.evproject.domain.Vehicles;
import ro.siit.java10.evproject.domain.enumeration.OrderStatus;
import ro.siit.java10.evproject.service.OrderItemServiceImp;
import ro.siit.java10.evproject.service.OrderServiceImp;
import ro.siit.java10.evproject.service.UserServiceImp;
import ro.siit.java10.evproject.service.VehicleServiceImp;

import java.util.List;

/**
 * REST controller for managing Order.
 */

@RestController
@RequestMapping
public class OrderController {

    @Autowired
    private OrderServiceImp orderServiceImp;
    private VehicleServiceImp vehicleServiceImp;
    private UserServiceImp userServiceImp;
    private OrderItemServiceImp orderItemServiceImp;
    private OrderDAO orderDAO;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public List<Order> listOrder() {
        return orderServiceImp.getAll();
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public Order getOrder(@PathVariable long id) {
        return orderServiceImp.getById(id);
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public Order createOrder(@RequestBody Order order) {
      return orderServiceImp.createOrder(order);
    }

    @RequestMapping(value = "/order/delete/{id}", method = RequestMethod.DELETE)
    public String deleteOrder(@PathVariable long id) {
        orderServiceImp.deleteOrder(id);
        return "deleted order";
    }

    @RequestMapping(value = "/order/submit", method = RequestMethod.POST)
    public Order submitOrder(@RequestBody Order order) {
        return orderServiceImp.submitOrder(order);
    }


}
