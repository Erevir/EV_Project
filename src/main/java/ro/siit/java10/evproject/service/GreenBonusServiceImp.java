package ro.siit.java10.evproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.java10.evproject.Repository.GreenBonusDAO;
import ro.siit.java10.evproject.Repository.OrderItemDAO;
import ro.siit.java10.evproject.Repository.VehicleDAO;
import ro.siit.java10.evproject.domain.GreenBonus;
import ro.siit.java10.evproject.exceptions.NotFoundException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class GreenBonusServiceImp implements GreenBonusService {

    @Autowired
    private GreenBonusDAO greenBonusDAO;
    @Autowired
    private VehicleDAO vehicleDAO;
    @Autowired
    private OrderItemDAO orderItemDAO;


    public List<GreenBonus>greenBonuses = new ArrayList<>();


    @Override
    public List<GreenBonus> getAll() {
       return greenBonusDAO.findAll();
    }

    @Override
    public GreenBonus createGreenBonus(GreenBonus greenBonus) {
        GreenBonus createGreenBonus = greenBonusDAO.save(greenBonus);
        return createGreenBonus;
    }

    @Override
    public GreenBonus getBonus(Long id) {
        List<GreenBonus> greenBonus = new ArrayList<>();
        if(!greenBonus.isEmpty())throw new NotFoundException("No more GreenBonuses");
        return greenBonusDAO.getOne(id);
    }

    @Override
    public void deleteGreenBonus(Long id) {
        Optional<GreenBonus> greenBonus = greenBonusDAO.findById(id);
        if (!greenBonus.isPresent()) throw new NotFoundException("Bonus System with id " + id + " does not exist");
        greenBonusDAO.deleteById(id);

    }


}
