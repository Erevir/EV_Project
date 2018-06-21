package ro.siit.java10.evproject.domain;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "GreenBonus")
public class GreenBonus implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @NotNull
        @Column(name = "start_date", nullable = false)
        private LocalDate startDate;

        @NotNull
        @Column(name = "end_date", nullable = false)
        private LocalDate endDate;

        @NotNull
        @Column(name = "amount", nullable = false)
        private int amount;

        @NotNull
        @Column(name = "quantity")
        private Integer quantity;

        @NotNull
        @Column(name = "is_active", nullable = false)
        private Boolean isActive;

    public GreenBonus(Long id, @NotNull LocalDate startDate,
                      @NotNull LocalDate endDate, @NotNull int amount,
                      @NotNull Integer quantity, @NotNull Boolean isActive) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.quantity = quantity;
        this.isActive = isActive;
    }
//
//        private int greenBonus; // = 10 000;
//    private int totalBonusFund; //= 10 000 000;

    public GreenBonus(){

    }

    public Long getId() {
        return id;
    }

    public GreenBonus setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public GreenBonus setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public GreenBonus startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public GreenBonus setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public GreenBonus endDate(LocalDate endDate) {
        this.endDate = endDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GreenBonus greenBonus = (GreenBonus) o;
        if(greenBonus.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, greenBonus.id);
    }

    public void useCoupon() {
        if (quantity > 0) quantity--;
    }

    public boolean isValidToday() {
        LocalDate today = LocalDate.now();
        return quantity > 0 && today.isAfter(startDate) && today.isBefore(endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "GreenBonus{" +
                "id=" + id +
                ", startDate='" + startDate + "'" +
                ", endDate='" + endDate + "'" +
                ", amount='" + amount + "'" +
                ", quantity='" + quantity + "'" +
                ", isActive='" + isActive + "'" +
                '}';
    }

    public void addQuantity() {
        quantity++;
    }
}



