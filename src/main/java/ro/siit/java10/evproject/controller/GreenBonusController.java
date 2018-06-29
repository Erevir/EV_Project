package ro.siit.java10.evproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.siit.java10.evproject.domain.GreenBonus;
import ro.siit.java10.evproject.service.GreenBonusServiceImp;
import ro.siit.java10.evproject.service.OrderItemServiceImp;
import ro.siit.java10.evproject.service.VehicleServiceImp;

import java.util.List;

/**
 * REST controller for managing Bonus System.
 */

@RestController
@RequestMapping
public class GreenBonusController {

    @Autowired
    private GreenBonusServiceImp greenBonusServiceImp;
    private VehicleServiceImp vehicleServiceImp;
    private OrderItemServiceImp orderItemServiceImp;

    @RequestMapping(value = "/greenBonus", method = RequestMethod.GET)
    public List<GreenBonus> listGreenBonus() {
        return greenBonusServiceImp.getAll();
    }

//    @RequestMapping(value = "/greenBonus/{id}", method = RequestMethod.GET)
//    public GreenBonus getGreenBonus(@PathVariable long id) {
//        GreenBonus greenBonus = greenBonusServiceImp.getBonus(id);
//        return greenBonus;
//    }

    @RequestMapping(value = "/greenBonus", method = RequestMethod.POST) //create & update
    public GreenBonus createGreenBonus(@RequestBody GreenBonus greenBonus) {
        GreenBonus createdGreenBonus = greenBonusServiceImp.createGreenBonus(greenBonus);
        return createdGreenBonus;
    }

    @RequestMapping(value = "/greenBonus/{id}", method = RequestMethod.DELETE)
    public String removeGreenBonus(@PathVariable long id) {
        greenBonusServiceImp.deleteGreenBonus(id);
        return "deleted";
    }
}
