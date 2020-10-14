package com.tyeporter.handson7.company.employee;

/***********************************************************
 * Engineer represents an engineer/empoyee at a company 
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-13-2020
 ***********************************************************/

public class Engineer extends Employee{
    // Properties
    private String jobTitle;

    // =========================================================
    // Constructors
    // =========================================================

    public Engineer() {
        super();
        this.jobTitle = "";
    }

    public Engineer(String firstName, 
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
