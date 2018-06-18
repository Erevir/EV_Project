package ro.siit.java10.evproject.service;

import ro.siit.java10.evproject.domain.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    void createUser(User user);

    void removeUser(String id);

    void updateUser(User user, String id);

    User getById(String id);

}
