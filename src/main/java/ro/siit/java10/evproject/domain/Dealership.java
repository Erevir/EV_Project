package ro.siit.java10.evproject.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "dealership")
public class Dealership implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="DealershipName")
    private String dealerShipName;

    @Column(name="DealershipAddress")
    private String dealerShipAddress;

    @Column(name="DealershipEmailAddress")
    private String dealerShipEmailAddress;

    public Dealership(){

    }
    public Dealership(String dealerShipName, String dealerShipAddress, String dealerShipEmailAddress) {
        this.dealerShipName = dealerShipName;
        this.dealerShipAddress = dealerShipAddress;
        this.dealerShipEmailAddress = dealerShipEmailAddress;
    }

    public String getDealerShipAddress() {
        return dealerShipAddress;
    }

    public Dealership setDealerShipAddress(String dealerShipAddress) {
        this.dealerShipAddress = dealerShipAddress;
        return this;
    }

    public String getDealerShipEmailAddress() {
        return dealerShipEmailAddress;
    }

    public Dealership setDealerShipEmailAddress(String dealerShipEmailAddress) {
        this.dealerShipEmailAddress = dealerShipEmailAddress;
        return this;
    }

    public String getDealerShipName() {
        return dealerShipName;
    }

    public Dealership setDealerShipName(String dealerShipName) {
        this.dealerShipName = dealerShipName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dealership)) return false;
        Dealership that = (Dealership) o;
        return Objects.equals(getDealerShipName(), that.getDealerShipName()) && Objects.equals(getDealerShipAddress(),
                that.getDealerShipAddress()) && Objects.equals(getDealerShipEmailAddress(),
                that.getDealerShipEmailAddress());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getDealerShipName(), getDealerShipAddress(), getDealerShipEmailAddress());
    }

    @Override
    public String toString() {
        return "Dealership{" + "dealerShipName='" + dealerShipName + '\''
                + ", dealerShipAddress='" + dealerShipAddress + '\''
                + ", dealerShipEmailAddress='" + dealerShipEmailAddress + '\'' + '}';
    }

}
