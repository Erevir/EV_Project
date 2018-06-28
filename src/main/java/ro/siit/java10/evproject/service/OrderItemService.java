package ro.siit.java10.evproject.service;

import ro.siit.java10.evproject.domain.OrderItem;

import java.util.List;

public interface OrderItemService {

    List<OrderItem> getAll();

    OrderItem getById(Long id);

    OrderItem createOrderItem(OrderItem orderItem);

    void deleteOrderItem(Long id);
}
