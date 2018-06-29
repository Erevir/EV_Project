package ro.siit.java10.evproject.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A GreenBonus Entity.
 */

@Entity
@Table(name = "GreenBonus")
public class GreenBonus implements Serializable {

    private WebContent.static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue //(strategy = GenerationType.AUTO)
    private Long id;  // ID for Bonus programmes

    @Column(name = "bonusName")
    private String bonusName;

//        @NotNull
//        @Column(name = "start_date", nullable = false)
//        private LocalDate startDate;
//
//        @NotNull
//        @Column(name = "end_date", nullable = false)
//        private LocalDate endDate;

        @NotNull
        @Column(name = "amount", nullable = false)
        private int amount;

        @NotNull
        @Max (value= 1000)
        @Column(name = "quantity")
        private Integer quantity;

//        @NotNull
//        @Column(name = "is_active", nullable = false)
//        private Boolean isActive;

    public Long getId() {
        return id;
    }

    public GreenBonus setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBonusName() {
        return bonusName;
    }

    public GreenBonus setBonusName(String bonusName) {
        this.bonusName = bonusName;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public GreenBonus setAmount(int amount) {
        this.amount = amount;
        return this;
    }
    public GreenBonus amount(int amount) {
        this.amount = amount;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public GreenBonus setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public GreenBonus quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
    public void addQuantity() {
        quantity++;
    }

    public void useBonus() {
        if (quantity > 0) quantity--;
    }

//    public boolean isValid() {
//        todo in GreenBonusService
//        return (orderItem.getVehicles().getFuelType() == FuelType.ELECTRIC & orderItem.getVehicles().isUsedVehicle());
//    }


    @Override
    public String toString() {
        return "GreenBonus{" + "id=" + id + ", bonusName='" + bonusName + '\'' + ", amount=" + amount + ", quantity=" + quantity + '}';
    }
}

//    public LocalDate getStartDate() {
//        return startDate;
//    }
//
//    public GreenBonus setStartDate(LocalDate startDate) {
//        this.startDate = startDate;
//        return this;
//    }
//
//    public GreenBonus startDate(LocalDate startDate) {
//        this.startDate = startDate;
//        return this;
//    }
//
//    public LocalDate getEndDate() {
//        return endDate;
//    }
//
//    public GreenBonus setEndDate(LocalDate endDate) {
//        this.endDate = endDate;
//        return this;
//    }
//
//    public GreenBonus endDate(LocalDate endDate) {
//        this.endDate = endDate;
//        return this;
//    }
//    public boolean isValidToday() {
//        LocalDate today = LocalDate.now();
//        return quantity > 0 && today.isAfter(startDate) && today.isBefore(endDate);
//    }




