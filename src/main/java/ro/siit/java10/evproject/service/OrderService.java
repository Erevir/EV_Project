package ro.siit.java10.evproject.service;

import org.springframework.stereotype.Service;
import ro.siit.java10.evproject.domain.Order;

import java.util.List;

@Service
public interface OrderService {

    public List<Order> getAll();

    public void createOrder(String id);

    public  void deleteOrder(String id);
}
