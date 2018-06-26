package ro.siit.java10.evproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.java10.evproject.Repository.UserDao;
import ro.siit.java10.evproject.domain.User;
import ro.siit.java10.evproject.exceptions.NotFoundException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImp implements UserService {

    public List<User> users = new ArrayList<>();

    @Autowired
    private UserDao userDao;


    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public User createUser(User userToCreate) {
        User createUser = userDao.save(userToCreate);
        return createUser;
    }

    @Override
    public void removeUser(long id) {
        Optional<User> user = userDao.findById(id);
        if (!user.isPresent()) throw new NotFoundException("User with id " + id + " does not exist");
        userDao.deleteById(id);
    }

    @Override
    public User getById(long id) {
        Optional<User> user = userDao.findById(id);
        if (!user.isPresent()) throw new NotFoundException("User with id " + id + " does not exist");
        return user.get();
    }

//    public Optional<User> findByLastname(String lastName){
//
//        return userDao.findByLastname();
//    }
}

