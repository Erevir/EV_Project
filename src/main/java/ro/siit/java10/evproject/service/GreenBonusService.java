package ro.siit.java10.evproject.service;

import org.springframework.stereotype.Service;
import ro.siit.java10.evproject.domain.GreenBonus;
import ro.siit.java10.evproject.domain.User;

import java.util.List;


public interface GreenBonusService {

    List<GreenBonus> getAll();

    /**
     *
     * @param greenBonus, create, update and delete BonusSystem, id = new BonusSystem(GreenBonus in my case)
     * @return
     */

    GreenBonus createGreenBonus(GreenBonus greenBonus);

    GreenBonus getBonus(Long id );

    void deleteGreenBonus(Long id);
}
