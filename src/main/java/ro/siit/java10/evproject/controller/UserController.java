package ro.siit.java10.evproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.siit.java10.evproject.domain.User;
import ro.siit.java10.evproject.service.DealershipServiceImp;
import ro.siit.java10.evproject.service.UserServiceImp;

import java.util.List;

/**
 * REST controller for managing User.
 */

@RestController
//@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;
    private DealershipServiceImp dealershipServiceImp;


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> listUsers() {
        return userServiceImp.getAll();
    }


    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable long id) {
        return userServiceImp.getById(id);
    }

//    @RequestMapping(value = "/user/findByLastName}", method = RequestMethod.GET)
//    public Optional<User> findByLastName(@PathVariable String lastName) {
//        Optional<User> user = userServiceImp.findByLastname(lastName);
//        return user;
//    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return userServiceImp.createUser(user);
    }

    @RequestMapping(value = "/users/delete/{id}", method = RequestMethod.DELETE)
    public String removeUser(@PathVariable long id) {
        userServiceImp.removeUser(id);
        return "deleted";
    }
}
