package ro.siit.java10.evproject.service;

import ro.siit.java10.evproject.domain.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    List<User> getAll(); // read user

    User createUser(User user); //create and update user

    void removeUser(long id); // delete user

    User getById(long id); // read user by id

//    Optional<User> findByLastname();

}
