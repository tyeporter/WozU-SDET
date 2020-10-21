package com.tyeporter.halloffamers.service;

import java.util.List;
import com.tyeporter.halloffamers.model.HallOfFamer;
import com.tyeporter.halloffamers.repo.HallOfFamerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HallOfFamerService {

    @Autowired
    HallOfFamerRepo repo;

    public void addHallOfFamer(String firstName, String lastName, String sport, String organization) {
        this.repo.save(new HallOfFamer(firstName, lastName, sport, organization));
    }

    public List<HallOfFamer> getAllHallOfFamers() {
        return this.repo.findAll();
    }
    
}
