package com.tyeporter.halloffamers;

import com.tyeporter.halloffamers.repo.HallOfFamerRepo;
import com.tyeporter.halloffamers.service.HallOfFamerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    HallOfFamerRepo repo;

    @Autowired
    HallOfFamerService service;

    @Override
    public void run(String... args) throws Exception {
        this.service.addHallOfFamer("Michael", "Jordan", "Basketball", "NBA");
        this.service.addHallOfFamer("Barry", "Bonds", "Baseball", "MLB");
        this.service.addHallOfFamer("Walter", "Payton", "American Football", "NFL");
    }
    
}
