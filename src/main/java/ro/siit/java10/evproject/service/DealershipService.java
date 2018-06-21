package ro.siit.java10.evproject.service;

import org.springframework.stereotype.Service;
import ro.siit.java10.evproject.domain.Dealership;

import java.util.List;


public interface DealershipService {

    List<Dealership> getAll();

    void createDealership(Dealership dealership);

    void updateDealership(Dealership dealership, String dealerShipName);

    void deleteDealership(String dealerShipName);

    Dealership getByName(String dealerShipName);
}
