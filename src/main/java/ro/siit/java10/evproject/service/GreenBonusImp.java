package ro.siit.java10.evproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.java10.evproject.dao_Repository.GreenBonusDAO;
import ro.siit.java10.evproject.domain.GreenBonus;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class GreenBonusImp implements GreenBonusService {

    @Autowired
    private GreenBonusDAO greenBonusDAO;


    public List<GreenBonus>greenBonuses = new ArrayList<>();

    public GreenBonusImp(GreenBonusDAO greenBonusDAO) {
        this.greenBonusDAO = greenBonusDAO;
    }

    @Override
    public List<GreenBonus> getAll() {
        return greenBonuses;
    }

    @Override
    public void getBonus(GreenBonus greenBonus) {

    }
}
