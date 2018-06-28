package ro.siit.java10.evproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.siit.java10.evproject.domain.Order;
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

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public List<Order> listOrder() {
        return orderServiceImp.getAll();
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public Order getOrder(@PathVariable long id) {
        Order order = orderServiceImp.getById(id);
        return order;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public Order createOrder(@RequestBody Order order) {
        Order createdOrder = orderServiceImp.createOrder(order);
        return createdOrder;
    }

    @RequestMapping(value = "/order/delete/{id}", method = RequestMethod.DELETE)
    public String deleteOrder(@PathVariable long id) {
        orderServiceImp.deleteOrder(id);
        return "deleted order";
    }

    @RequestMapping(value = "/order/submit", method = RequestMethod.POST)
    public Order submitOrder(@RequestBody Order order) {
        Order submitedOrder = orderServiceImp.submitOrder(order);
        return submitedOrder;
    }

}
