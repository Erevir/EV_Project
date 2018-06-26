package ro.siit.java10.evproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.siit.java10.evproject.domain.Dealership;
import ro.siit.java10.evproject.service.DealershipServiceImp;

import java.util.List;

@RestController
@RequestMapping
public class DealershipController {

    @Autowired
    private DealershipServiceImp dealershipServiceImp;

    @RequestMapping(value = "/dealerships/all", method = RequestMethod.GET)
    public List<Dealership> listDealership() {
        return dealershipServiceImp.getAll();
    }

    @RequestMapping(value = "/dealerships/{id}", method = RequestMethod.GET)
    public Dealership getDealership(@PathVariable long id) {
        Dealership dealership = dealershipServiceImp.findById(id);
        return dealershipServiceImp.findById(id);
    }

    @RequestMapping(value = "/dealerships", method = RequestMethod.POST)
    public Dealership createDealership(@RequestBody Dealership dealership) {
        Dealership createdDealership = dealershipServiceImp.createDealership(dealership);
        return createdDealership;
    }

    @RequestMapping(value = "/dealerships/delete/{id}", method = RequestMethod.DELETE)
    public String removeDealership(@PathVariable long id) {
        dealershipServiceImp.deleteDealership(id);
        return "deleted dealership";
    }
}
