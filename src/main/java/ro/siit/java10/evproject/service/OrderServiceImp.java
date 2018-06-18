package ro.siit.java10.evproject.service;

import ro.siit.java10.evproject.domain.Order;
import ro.siit.java10.evproject.domain.Vehicles;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImp implements OrderService {

public int totalPrice;
Vehicles vehicles;

//    private void calculateTotalPrice() {
//        totalPrice = 0;
//        for (Order item : orders) {
//            item.setPrice(item.getProduct().getPrice()); // always use latest price
//            totalPrice = totalPrice + vehicles.getPrice() - item.getQuantity());
//        }
//        if (coupon != null) {
//            if (coupon.isValidToday() && totalPrice >= coupon.getMinimumPrice()) {
//                totalPrice -= coupon.isIsPercentage() ? (totalPrice * coupon.getAmount() / 100) : coupon.getAmount();
//            } else {
//                coupon = null; // not valid anymore
//            }
//
//        }
//    }
    List<Order>orders = new ArrayList<>();

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
