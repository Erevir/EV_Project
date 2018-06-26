package ro.siit.java10.evproject.service;

import org.springframework.data.domain.Page;
import ro.siit.java10.evproject.domain.Dealership;

import java.util.List;

public interface DealershipService {

    List<Dealership> getAll();

    Dealership createDealership(Dealership dealership);

    void deleteDealership(long id);

    Dealership findById(long id);

//    List<Dealership> findByName(String dealershipName);

//    Page<Dealership> findByNameContaining(String dealershipName, Integer pageNumber);

//    Dealership getByNameAndAddress(String dealershipName, String dealershipAddress);
}
