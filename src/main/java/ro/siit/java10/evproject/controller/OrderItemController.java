package ro.siit.java10.evproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.siit.java10.evproject.domain.OrderItem;
import ro.siit.java10.evproject.service.GreenBonusServiceImp;
import ro.siit.java10.evproject.service.OrderItemServiceImp;
import ro.siit.java10.evproject.service.VehicleServiceImp;

import java.util.List;

/**
 * REST controller for managing OrderItem.
 */

@RestController
@RequestMapping
public class OrderItemController {

    @Autowired
    private OrderItemServiceImp orderItemServiceImp;
    private GreenBonusServiceImp greenBonusServiceImp;
    private VehicleServiceImp vehicleServiceImp;

    @RequestMapping(value = "/orderItem", method = RequestMethod.GET)
    public List<OrderItem> listOrderItem() {
        return orderItemServiceImp.getAll();
    }

    @RequestMapping(value = "/orderItem/{id}", method = RequestMethod.GET)
    public OrderItem getOrderItem(@PathVariable long id) {
        return orderItemServiceImp.getById(id);
    }

    @RequestMapping(value = "/orderItem", method = RequestMethod.POST) //create & update
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemServiceImp.createOrderItem(orderItem);
    }

    @RequestMapping(value = "/orderItem/{id}", method = RequestMethod.DELETE)
    public String removeOrderItem(@PathVariable long id) {
        orderItemServiceImp.deleteOrderItem(id);
        return "deleted";
    }

}
