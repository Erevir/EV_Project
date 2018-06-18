package ro.siit.java10.evproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ro.siit.java10.evproject.domain.User;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Find all customers, thanks Java 8, you can create a custom RowMapper like this :

    public List<User> findAll() {

        List<User> result = jdbcTemplate.query(
                "SELECT id, FirstName, LastName, CustomerEmailAddress, CustomerMoneyFunds FROM customer",
                (rs, rowNum) -> new User().setId(rs.getString("id")).
                        setFirstName(rs.getString("FirstName")).
                        setLastName(rs.getString("LastName")).
                        setCustomerEmailAddress(rs.getString("CustomerEmailAddress")).
                        setCustomerFunds(rs.getInt("CustomerMoneyFunds"))

        );
        return result;

    }

    // Add new customer
    public void addCustomer(String id, String firstName, String lastName, String customerEmailAddress, int customerFunds ) {

        jdbcTemplate.update("INSERT INTO customer(id, FirstName, LastName, CustomerEmailAddress, CustomerMoneyFunds)" +
                        " VALUES (?,?,?,?,?)",
                id, firstName, lastName, customerEmailAddress, customerFunds);

    }


}
