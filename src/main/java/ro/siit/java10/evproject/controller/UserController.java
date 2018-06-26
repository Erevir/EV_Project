package ro.siit.java10.evproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.siit.java10.evproject.domain.User;
import ro.siit.java10.evproject.service.UserServiceImp;

import java.util.List;
import java.util.Optional;

@RestController
//@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> listUsers() {
        return userServiceImp.getAll();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable long id) {
        User user = userServiceImp.getById(id);
        return user;
    }

//    @RequestMapping(value = "/user/findByLastName}", method = RequestMethod.GET)
//    public Optional<User> findByLastName(@PathVariable String lastName) {
//        Optional<User> user = userServiceImp.findByLastname(lastName);
//        return user;
//    }


    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        User createdUser = userServiceImp.createUser(user);
        return createdUser;
    }

    @RequestMapping(value = "/users/delete/{id}", method = RequestMethod.DELETE)
    public String removeUser(@PathVariable long id) {
        userServiceImp.removeUser(id);
        return "deleted";
    }
}
