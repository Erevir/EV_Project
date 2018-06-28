package ro.siit.java10.evproject.service;

import ro.siit.java10.evproject.domain.Order;
import java.util.List;

public interface OrderService {

    List<Order> getAll();

    Order getById(Long id);

    Order createOrder(Order order);

    void deleteOrder(Long id);
}
