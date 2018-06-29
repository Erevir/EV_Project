package ro.siit.java10.evproject.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A User Entity.
 */

@Entity
@Table(name = "Customer")
public class User implements Serializable{

    private WebContent.static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue //(strategy=GenerationType.AUTO)-BY DEFOLT
    @Column(name="id")
    private long id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="customerEmailAddress")
    private String customerEmailAddress;

    @Column(name="customerFunds")
    private int customerFunds;

    public long getId() {
        return id;
    }

    public User setId(long id) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() && getCustomerFunds() == user.getCustomerFunds() && Objects.equals(getFirstName(), user.getFirstName()) && Objects.equals(getLastName(), user.getLastName()) && Objects.equals(getCustomerEmailAddress(), user.getCustomerEmailAddress());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getFirstName(), getLastName(), getCustomerEmailAddress(), getCustomerFunds());
    }

    @Override
    public String toString() {
        return "User{" + "id='" + id + '\'' + ", " +
                "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", " +
                "customerEmailAddress='" + customerEmailAddress + '\'' + ", customerFunds=" + customerFunds + '}';
    }
}
