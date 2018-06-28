package ro.siit.java10.evproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.java10.evproject.Repository.OrderItemDAO;
import ro.siit.java10.evproject.Repository.VehicleDAO;
import ro.siit.java10.evproject.domain.Order;
import ro.siit.java10.evproject.domain.OrderItem;
import ro.siit.java10.evproject.exceptions.NotFoundException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class OrderItemServiceImp implements OrderItemService{

    @Autowired
    private OrderItemDAO orderItemDAO;
    @Autowired
    private VehicleDAO vehicleDAO;

    List<OrderItem>orderItems = new ArrayList<>();

    @Override
    public List<OrderItem> getAll() {
        return orderItemDAO.findAll();
    }

    @Override
    public OrderItem getById(Long id) {
        Optional<OrderItem> orderItem = orderItemDAO.findById(id);
        if (!orderItem.isPresent()) throw new NotFoundException("OrderItem with id " + id + " does not exist");
        return orderItem.get();
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        OrderItem createOrderItem = orderItemDAO.save(orderItem);
        return createOrderItem;
    }

    @Override
    public void deleteOrderItem(Long id) {
        Optional<OrderItem> orderItem = orderItemDAO.findById(id);
        if (!orderItem.isPresent()) throw new NotFoundException("OrderItem with id " + id + " does not exist");
        orderItemDAO.deleteById(id);
    }

}
