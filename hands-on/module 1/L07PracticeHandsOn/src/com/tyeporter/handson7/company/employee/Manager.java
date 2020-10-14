package com.tyeporter.handson7.company.employee;

/***********************************************************
 * Manager represents a(n) manager/empoyee at a company 
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-13-2020
 ***********************************************************/

public class Manager extends Employee {
    // Properties
    private String jobTitle;

    // =========================================================
    // Constructors
    // =========================================================

    public Manager() {
        super();
        this.jobTitle = "";
    }

    public Manager(String firstName, 
                   String lastName,
                   String companyName, 
                   int yearsAtCompany,
                   String jobTitle) {
        super(firstName, lastName, companyName, yearsAtCompany);
        this.jobTitle = jobTitle;
    }


    // =========================================================
    // Setters
    // =========================================================
    
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }


    // =========================================================
    // Getters
    // =========================================================

    public String getJobTitle() {
        return jobTitle;
    }


    // =========================================================
    // @Overrides
    // =========================================================

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName() +
              " has worked for " + this.getCompanyName() + " for " +
              this.getYearsAtCompany() + " year(s) as a(n) " + 
              this.jobTitle + ".";
    }
    
}
