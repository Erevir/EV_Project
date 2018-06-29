package ro.siit.java10.evproject.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import ro.siit.java10.evproject.Repository.*;
import ro.siit.java10.evproject.domain.Dealership;
import ro.siit.java10.evproject.exceptions.NotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class DealershipServiceImp implements DealershipService {

    @Autowired
    private DealershipDAO dealershipDAO;
    private VehicleDAO vehicleDAO;
    private UserDao userDao;
    private GreenBonusDAO greenBonusDAO;
    private OrderDAO orderDAO;

    @Override
    public List<Dealership> getAll() {
        return (List<Dealership>) dealershipDAO.findAll();
    }

    @Override
    public Dealership createDealership(Dealership dealershipToCreate) {
        return dealershipDAO.save(dealershipToCreate);
    }

    @Override
    public void deleteDealership(long id) {
//        Optional<Dealership> dealership = dealershipDAO.findById(id);
//        if (!dealership.isPresent()) throw new NotFoundException("Dealership with id " + id + " does not exist");
        dealershipDAO.deleteById(id);
    }

    @Override
    public Dealership findById(long id) {
        Optional<Dealership> dealership = dealershipDAO.findById(id);
        if (!dealership.isPresent()) throw new NotFoundException("Dealership with id " + id + " does not exist");
        return dealership.get();
    }

//    @Override
//    public List<Dealership> findByName(String dealershipName) {
//        List<Dealership> listDealership = dealershipDAO.();
//        return listDealership;
////    }

//    @Override
//    public Page<Dealership> findByNameContaining(String dealershipName, Integer pageNumber) {
//        return dealershipDAO.findByNameContaining(dealershipName, new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "dealershipName"));
//
//    }
}
