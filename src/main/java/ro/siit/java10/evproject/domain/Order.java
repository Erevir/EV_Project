package ro.siit.java10.evproject.domain;

import java.util.Date;

public class Order {

    private String id;
    private Date orderDate;
    private int subTotalPrice;
    private int totalPrice;
    private GreenBonus greenBonusDiscount;
    private Vehicles vehicles;
    private User user;
    private Dealership dealership;

    public  Order(){

    }

    public Order(String id, Date orderDate, int subTotalPrice,
                 int totalPrice, GreenBonus greenBonusDiscount, Vehicles vehicles,
                 User user, Dealership dealership) {
        this.id = id;
        this.orderDate = orderDate;
        this.subTotalPrice = subTotalPrice;
        this.totalPrice = totalPrice;
        this.greenBonusDiscount = greenBonusDiscount;
        this.vehicles = vehicles;
        this.user = user;
        this.dealership = dealership;
    }

    public String getId() {
        return id;
    }

    public Order setId(String id) {
        this.id = id;
        return this;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Order setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public int getSubTotalPrice() {
        return subTotalPrice;
    }

    public Order setSubTotalPrice(int subTotalPrice) {
        this.subTotalPrice = subTotalPrice;
        return this;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public Order setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }
    @Override
    public String toString() {
        return "Order{" + "id='" + id + '\'' + ", orderDate=" + orderDate + ", " +
                "subTotalPrice=" + subTotalPrice + ", totalPrice=" + totalPrice + ", " +
                "greenBonusDiscount=" + greenBonusDiscount + ", vehicles=" + vehicles + ", " +
                "user=" + user + ", dealership=" + dealership + '}';
    }
}
