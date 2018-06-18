package ro.siit.java10.evproject.service;

import ro.siit.java10.evproject.domain.Dealership;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DealershipServiceImp implements DealershipService {

private List<Dealership> dealerships = new ArrayList<>();


    @Override
    public List<Dealership> getAll() {
        return dealerships;
    }

    @Override
    public void createDealership(Dealership dealership) {

    }

    @Override
    public void updateDealership(Dealership dealership, String dealerShipName) {

    }

    @Override
    public void deleteDealership(String dealerShipName) {

    }

    @Override
    public Dealership getByName(String dealerShipName) {
        //TODO check that the id exists
        return dealerships.stream().filter(c -> c.getDealerShipName() == dealerShipName).collect(Collectors.toList()).get(0);
    }
}
