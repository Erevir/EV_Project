package ro.siit.java10.evproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.siit.java10.evproject.domain.Dealership;
import ro.siit.java10.evproject.dto.CreateUserReguest;
import ro.siit.java10.evproject.service.DealershipServiceImp;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/dealerships")
public class DealershipController {

    @Autowired
    private DealershipServiceImp dealershipServiceImp;

    @RequestMapping(value = "/dealerships", method = RequestMethod.GET)
    public String listDealership(Model model, HttpServletRequest request) {
        List<Dealership> dealerships = dealershipServiceImp.getAll();
        model.addAttribute("dealership", dealerships);
       model.addAttribute("createClientRequest", new CreateUserReguest());

        return "listDealership";
    }


    @RequestMapping(value = "/dealerships", method = RequestMethod.POST)
    public String createDealership(Dealership dealership, Model model) {
        dealershipServiceImp.createDealership(dealership);
        List<Dealership> dealerships = dealershipServiceImp.getAll();
        model.addAttribute("dealership", dealerships);

        return "redirect:/dealerships";
    }

    @RequestMapping(value = "/dealerships/{dealerShipName}", method = RequestMethod.GET)
    public String getDealership(@PathVariable String dealerShipName, Model model) {
        Dealership dealerships = dealershipServiceImp.getByName(dealerShipName);
        model.addAttribute("dealership_name", dealerShipName);
        return "updateDealerships";
    }


    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.POST)
    public String removeDealership(@PathVariable String dealerShipName, Model model) {

        dealershipServiceImp.deleteDealership(dealerShipName);

        return "redirect:/dealerships";
    }
}
