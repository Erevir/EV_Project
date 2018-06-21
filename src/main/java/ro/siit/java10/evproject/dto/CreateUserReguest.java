package ro.siit.java10.evproject.dto;

public class CreateUserReguest {

    private long id;
    private String firstName;
    private String lastName;
    private String customerEmailAddress;
    private int customerFunds;

    public long getId() {
        return id;
    }

    public CreateUserReguest setId(long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CreateUserReguest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CreateUserReguest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }

    public CreateUserReguest setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
        return this;
    }

    public int getCustomerFunds() {
        return customerFunds;
    }

    public CreateUserReguest setCustomerFunds(int customerFunds) {
        this.customerFunds = customerFunds;
        return this;
    }
}
