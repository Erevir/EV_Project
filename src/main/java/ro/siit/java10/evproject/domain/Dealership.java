package ro.siit.java10.evproject.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "dealership")
public class Dealership implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    private long id;

    @Column(name="dealershipName")
    private String dealershipName;

    @Column(name="dealershipAddress")
    private String dealershipAddress;

    @Column(name="dealershipEmailAddress")
    private String dealershipEmailAddress;

    @OneToMany(mappedBy = "dealership", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Vehicles> vehicles;

    public long getId() {
        return id;
    }

    public Dealership setId(long id) {
        this.id = id;
        return this;
    }

    public String getDealershipName() {
        return dealershipName;
    }

    public Dealership setDealershipName(String dealershipName) {
        this.dealershipName = dealershipName;
        return this;
    }

    public String getDealershipAddress() {
        return dealershipAddress;
    }

    public Dealership setDealershipAddress(String dealershipAddress) {
        this.dealershipAddress = dealershipAddress;
        return this;
    }

    public String getDealershipEmailAddress() {
        return dealershipEmailAddress;
    }

    public Dealership setDealershipEmailAddress(String dealershipEmailAddress) {
        this.dealershipEmailAddress = dealershipEmailAddress;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dealership)) return false;
        Dealership that = (Dealership) o;
        return getId() == that.getId() && Objects.equals(getDealershipName(), that.getDealershipName()) && Objects.equals(getDealershipAddress(), that.getDealershipAddress()) && Objects.equals(getDealershipEmailAddress(), that.getDealershipEmailAddress());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getDealershipName(), getDealershipAddress(), getDealershipEmailAddress());
    }

    @Override
    public String toString() {
        return "Dealership{" + "id=" + id + ", dealershipName='" + dealershipName + '\''
                + ", dealershipAddress='" + dealershipAddress + '\'' + ", dealershipEmailAddress='"
                + dealershipEmailAddress + '\'' + '}';
    }

    public List<Vehicles> getVehicles() {
        return vehicles;
    }

    public Dealership setVehicles(List<Vehicles> vehicles) {
        this.vehicles = vehicles;
        return this;
    }

}
