package ro.siit.java10.evproject.service;

import org.springframework.stereotype.Service;
import ro.siit.java10.evproject.domain.User;

import java.util.List;


@Service
public interface UserService {

    List<User> getAll();

    void createUser(User user);

    void removeUser(long id);

    void updateUser(User user, long id);

    User getById(long id);

}
