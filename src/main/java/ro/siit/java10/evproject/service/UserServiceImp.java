package ro.siit.java10.evproject.service;

import ro.siit.java10.evproject.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImp implements UserService  {

    public List<User> users = new ArrayList<>();

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void createUser(User id) {
//        users.setId();
//        users.add(u);

    }

    @Override
    public void removeUser(String id) {
        users = users.stream().filter(c -> c.getId() != id).collect(Collectors.toList());

    }

    @Override
    public void updateUser(User user, String id) {
      users = users.stream().filter(c -> c.getId() != id).collect(Collectors.toList());
//       users.setId(id);
//       users.add(User);
    }

    @Override
    public User getById(String id) {
        //TODO check that the id exists
        return users.stream().filter(c -> c.getId() == id).collect(Collectors.toList()).get(0);

        }
}

