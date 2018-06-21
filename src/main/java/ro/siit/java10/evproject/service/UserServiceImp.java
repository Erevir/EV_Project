package ro.siit.java10.evproject.service;

import org.springframework.stereotype.Service;
import ro.siit.java10.evproject.domain.User;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
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
    public void removeUser(long id) {
        users = users.stream().filter(c -> c.getId() != id).collect(Collectors.toList());

    }

    @Override
    public void updateUser(User user, long id) {
      users = users.stream().filter(c -> c.getId() != id).collect(Collectors.toList());
//       users.setId(id);
//       users.add(User);
    }

    @Override
    public User getById(long id) {
        //TODO check that the id exists
        return users.stream().filter(c -> c.getId() == id).collect(Collectors.toList()).get(0);

        }
}

