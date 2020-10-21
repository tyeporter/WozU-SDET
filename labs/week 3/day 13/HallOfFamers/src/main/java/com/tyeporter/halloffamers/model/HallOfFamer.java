package com.tyeporter.halloffamers.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HallOfFamer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String sport;
    private String organization;

    public HallOfFamer() {}

    public HallOfFamer(String firstName, String lastName, String sport, String organization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sport = sport;
        this.organization = organization;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSport() {
        return sport;
    }

    public String getOrganization() {
        return organization;
    }
}
