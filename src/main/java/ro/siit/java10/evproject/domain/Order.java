package ro.siit.java10.evproject.domain;

import ro.siit.java10.evproject.domain.enumeration.OrderStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Order Entity.
 */

@Entity
@Table(name = "sales_order")
public class Order implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "total_price")
    private long totalPrice;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @Column(name = "payment_info")
    private String paymentInfo;

    @ManyToOne
    @NotNull
    private User user;

    @OneToOne
    private GreenBonus greenBonus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public Order date(Date date) {
        this.date = date;
        return this;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public Order totalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Order status(OrderStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public Order paymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
        return this;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public User getUser() {
        return user;
    }

    public Order user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GreenBonus getGreenBonus() {
        return greenBonus;
    }

    public Order greenBonus(GreenBonus greenBonus) {
        this.greenBonus = greenBonus;
        return this;
    }

    public void setGreenBonus(GreenBonus greenBonus) {
        this.greenBonus = greenBonus;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Order orderItems(Set<OrderItem> orderItems) {
        setOrderItems(orderItems);
        return this;
    }

    public Order addOrderItem(OrderItem orderItem) { // add or update an OrderItem
        if (orderItem.getId() == null) { // new item
            boolean isNewItem = true;
            for (OrderItem item : orderItems) {
                if (item.getVehicles().getVinCode() == orderItem.getVehicles().getVinCode()) { // add to existing item
                    orderItem = item.merge(orderItem);
                    isNewItem = false;
                    break;
                }
            }
            if (isNewItem) {
                orderItems.add(orderItem);
                orderItem.setOrder(this);
            }
        } else {
            for (OrderItem item : orderItems) { //find existing item
                if (item.getId() == orderItem.getId()) {
                    orderItem = item.merge(orderItem);
                    break;
                }
            }
        }
        calculateTotalPrice();
        return this;
    }

    public Order removeOrderItem(OrderItem orderItem) {
        orderItems.remove(orderItem);
        orderItem.setOrder(null);
        return this;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        Set<OrderItem> deleteItems = new HashSet<>();
        boolean isFound;
        for (OrderItem item : this.orderItems) {
            isFound = false;
            for (OrderItem newItem : orderItems) {
                if (item.getId() == newItem.getId()) {
                    isFound = true;
                    if (newItem.getQuantity() == 0) deleteItems.add(newItem);
                    break;
                }
            }
            if (!isFound) return; //new orderItems not valid
        }
        if (deleteItems.size() > 0) {
            for (OrderItem item : deleteItems) {
                orderItems.remove(item);
                item.setOrder(null);
            }
        }
        this.orderItems = orderItems;
    }

    public boolean approveOrder() {
        if (paymentInfo != null && status == OrderStatus.PENDING) status = OrderStatus.PAID;
        return status == OrderStatus.PAID;
    }

    private void calculateTotalPrice() {
        totalPrice = 0;
        for (OrderItem item : orderItems) {
            item.setPrice(item.getVehicles().getPrice());
            totalPrice = totalPrice + (item.getPrice() * item.getQuantity());
        }
        if (greenBonus != null) {
            if (totalPrice >= greenBonus.getAmount()) {
                totalPrice -= totalPrice - greenBonus.getAmount();
            } else {
                greenBonus = null; // not valid anymore
            }

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        if(order.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date='" + date + "'" +
                ", totalPrice='" + totalPrice + "'" +
                ", status='" + status + "'" +
                ", paymentInfo='" + paymentInfo + "'" +
                '}';
    }

}