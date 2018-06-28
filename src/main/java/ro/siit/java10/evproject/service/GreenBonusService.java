package ro.siit.java10.evproject.service;

import ro.siit.java10.evproject.domain.GreenBonus;
import java.util.List;

/**
  *  create, update and delete BonusSystem, id = new BonusSystem(GreenBonus in my case)
  */
public interface GreenBonusService {

    List<GreenBonus> getAll();

    GreenBonus createGreenBonus(GreenBonus greenBonus);

//    GreenBonus getBonus(Long id );

    void deleteGreenBonus(Long id);
}
