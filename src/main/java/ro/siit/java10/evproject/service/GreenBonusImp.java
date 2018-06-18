package ro.siit.java10.evproject.service;

import ro.siit.java10.evproject.domain.GreenBonus;

import java.util.ArrayList;
import java.util.List;

public class GreenBonusImp implements GreenBonusService {

    public List<GreenBonus>greenBonuses = new ArrayList<>();

    @Override
    public List<GreenBonus> getAll() {
        return greenBonuses;
    }

    @Override
    public void getBonus(GreenBonus greenBonus) {

    }
}
