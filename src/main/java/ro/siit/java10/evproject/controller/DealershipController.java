package ro.siit.java10.evproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.siit.java10.evproject.domain.Dealership;
import ro.siit.java10.evproject.domain.User;
import ro.siit.java10.evproject.dto.CreateUserReguest;
import ro.siit.java10.evproject.service.DealershipService;
import ro.siit.java10.evproject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DealershipController {

    @Autowired
    private DealershipService dealershipService;


    @RequestMapping(value = "/dealerships", method = RequestMethod.GET)
    public String listDealership(Model model, HttpServletRequest request) {
        List<Dealership> dealerships = dealershipService.getAll();
        model.addAttribute("dealership", dealerships);
//        model.addAttribute("createClientRequest", new CreateUserReguest());

        return "listDealership";
    }



//
//    @RequestMapping(value = "/dealerships", method = RequestMethod.POST)
//    public String createDealership(Dealership dealership, Model model) {
//        Dealership dealerships = getDealership(dealership);
//        dealershipService.createDealership(dealerships);
//
//        return "redirect:/dealerships";
//    }

    @RequestMapping(value = "/dealerships/{dealerShipName}", method = RequestMethod.GET)
    public String getDealership(@PathVariable String dealerShipName, Model model) {
        Dealership dealerships = dealershipService.getByName(dealerShipName);
        model.addAttribute("dealership_name", dealerShipName);
        return "updateDealerships";
    }


    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.POST)
    public String removeUser(@PathVariable String dealerShipName, Model model) {

        dealershipService.deleteDealership(dealerShipName);

        return "redirect:/dealerships";
    }
}
