package ro.siit.java10.evproject.domain;

public class User {

    private String id;
    private String firstName;
    private String lastName;
    private String customerEmailAddress;
    private int customerFunds;

    public User (){

    }
    public User(String id, String firstName, String lastName, String customerEmailAddress, int customerFunds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerEmailAddress = customerEmailAddress;
        this.id = id;
        this.customerFunds = customerFunds;

    }
    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }

    public User setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
        return this;
    }

    public int getCustomerFunds() {
        return customerFunds;
    }

    public User setCustomerFunds(int customerFunds) {
        this.customerFunds = customerFunds;
        return this;
    }

    @Override
    public String toString() {
        return "User{" + "id='" + id + '\'' + ", " +
                "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", " +
                "customerEmailAddress='" + customerEmailAddress + '\'' + ", customerFunds=" + customerFunds + '}';
    }
}
