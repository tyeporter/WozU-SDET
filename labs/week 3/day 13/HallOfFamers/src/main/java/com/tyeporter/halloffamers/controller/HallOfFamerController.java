package com.tyeporter.halloffamers.controller;

import java.util.List;
import com.tyeporter.halloffamers.model.HallOfFamer;
import com.tyeporter.halloffamers.service.HallOfFamerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HallOfFamerController {

    @Autowired
    HallOfFamerService service;

    @PostMapping("/barry")
    public void postBarry() {
        this.service.addHallOfFamer("Barry", "Sanders", "American Football", "NFL");
    }

    @GetMapping("/getall")
    public List<HallOfFamer> getAllHallOfFamers() {
        return this.service.getAllHallOfFamers();
    }
    
}
