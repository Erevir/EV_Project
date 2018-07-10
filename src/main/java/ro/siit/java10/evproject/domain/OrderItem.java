package ro.siit.java10.evproject.domain;

import ro.siit.java10.evproject.domain.enumeration.FuelType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A OrderItem Entity.
 */

@Entity
@Table(name = "order_item")

public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "price")
    private int price;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToOne
    @NotNull
    private Vehicles vehicles;

    @ManyToOne
    @NotNull
    private Order order;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderItem quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderItem price(int price) {
        this.price = price;
        return this;
    }

    public Vehicles getVehicles() {
        return vehicles;
    }

    public boolean isGreenBonusValid() {
        return (getVehicles().getFuelType() == FuelType.ELECTRIC & !getVehicles().isUsedVehicle());
    }

    public OrderItem vehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
        this.price = vehicles.getPrice();
        return this;
    }

    public void setVehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
        this.price = vehicles.getPrice();
    }

    public OrderItem order(Order order) {
        this.order = order;
        return this;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderItem merge(OrderItem orderItem) {
        if (orderItem.getVehicles().getVinCode() == vehicles.getVinCode())  //same specification uniquie vinCode
            this.quantity += orderItem.getQuantity();
        this.price = orderItem.getVehicles().getPrice();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderItem orderItem = (OrderItem) o;
        if (orderItem.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "OrderItem{" + "id=" + id + ", price='" + price + "'" + ", quantity='" + quantity + "'" + '}';
    }

}
