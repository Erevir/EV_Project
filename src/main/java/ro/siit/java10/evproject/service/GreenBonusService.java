package ro.siit.java10.evproject.service;

import org.springframework.stereotype.Service;
import ro.siit.java10.evproject.domain.GreenBonus;

import java.util.List;


public interface GreenBonusService {

    List<GreenBonus> getAll();

    void getBonus(GreenBonus greenBonus );
}
