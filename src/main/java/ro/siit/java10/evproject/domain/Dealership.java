package ro.siit.java10.evproject.domain;

public class Dealership {

    private String dealerShipName;
    private String dealerShipAddress;
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
    public String toString() {
        return "Dealership{" + "dealerShipName='" + dealerShipName + '\''
                + ", dealerShipAddress='" + dealerShipAddress + '\''
                + ", dealerShipEmailAddress='" + dealerShipEmailAddress + '\'' + '}';
    }

}
