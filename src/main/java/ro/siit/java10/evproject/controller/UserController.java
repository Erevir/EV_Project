package ro.siit.java10.evproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.siit.java10.evproject.domain.User;
import ro.siit.java10.evproject.dto.CreateUserReguest;
import ro.siit.java10.evproject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String listUsers(Model model, HttpServletRequest request) {
        List<User> users = userService.getAll();
        model.addAttribute("user", users);
        model.addAttribute("createClientRequest", new CreateUserReguest());

        return "listUsers";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String createUser(CreateUserReguest userReguest, Model model) {
        User users = getUser(userReguest);
        userService.createUser(users);

        return "redirect:/user";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable String id, Model model) {
        User users = userService.getById(id);
        model.addAttribute("updateUserRequest", getUserRequest(users));
        model.addAttribute("user_id", id);
        return "updateUser";
    }


    @RequestMapping(value = "/user/update/{id}", method = RequestMethod.POST)
    public String updateUser(CreateUserReguest userReguest, @PathVariable String id) {

        User user = getUser(userReguest);
        userService.updateUser(user,id);

        return "redirect:/user";
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.POST)
    public String removeUser(@PathVariable String id, Model model) {

        userService.removeUser(id);

        return "redirect:/user";
    }

    private User getUser(CreateUserReguest userReguest) {

        User user = new User();
        user.setFirstName(userReguest.getFirstName());
        user.setLastName(userReguest.getLastName());
        user.setCustomerEmailAddress(userReguest.getCustomerEmailAddress());
        user.setCustomerFunds(userReguest.getCustomerFunds());
//        user.setPhoneNumber(clientRequest.getPhoneNumber());



        return user;
    }

    private CreateUserReguest getUserRequest(User user) {
        CreateUserReguest createUserReguest = new CreateUserReguest();

        createUserReguest.setFirstName(user.getFirstName());
        createUserReguest.setLastName(user.getLastName());
        createUserReguest.setCustomerEmailAddress(user.getCustomerEmailAddress());
        createUserReguest.setCustomerFunds(user.getCustomerFunds());


        return createUserReguest;

    }
}
