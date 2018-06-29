package ro.siit.java10.evproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.java10.evproject.Repository.GreenBonusDAO;
import ro.siit.java10.evproject.Repository.OrderItemDAO;
import ro.siit.java10.evproject.Repository.VehicleDAO;
import ro.siit.java10.evproject.domain.GreenBonus;
import ro.siit.java10.evproject.exceptions.NotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GreenBonusServiceImp implements GreenBonusService {

    @Autowired
    private GreenBonusDAO greenBonusDAO;
    private VehicleDAO vehicleDAO;
    private OrderItemDAO orderItemDAO;

    @Override
    public List<GreenBonus> getAll() {
        return greenBonusDAO.findAll();
    }

    @Override
    public GreenBonus createGreenBonus(GreenBonus greenBonus) {
        return greenBonusDAO.save(greenBonus);
    }

    @Override
    public void deleteGreenBonus(Long id) {
        Optional<GreenBonus> greenBonus = greenBonusDAO.findById(id);
        if (!greenBonus.isPresent()) throw new NotFoundException("Bonus System with id " + id + " does not exist");
        greenBonusDAO.deleteById(id);

    }
}
