package com.tyeporter.handson7.company.employee;

/***********************************************************
 * Employee represents an employee at a company 
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-13-2020
 ***********************************************************/

public class Employee {
    // Properties
    private String firstName;
    private String lastName;
    private String companyName;
    private int yearsAtCompany;

    // =========================================================
    // Constructors
    // =========================================================

    public Employee() {
        this.firstName = "";
        this.lastName = "";
        this.companyName = "";
        this.yearsAtCompany = -1;
    }

    public Employee(String firstName, 
                    String lastName,
                    String companyName, 
                    int yearsAtCompany) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.yearsAtCompany = yearsAtCompany;
    }

    // =========================================================
    // Setters
    // =========================================================

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setYearsAtCompany(int yearsAtCompany) {
        this.yearsAtCompany = yearsAtCompany;
    }


    // =========================================================
    // Getters
    // =========================================================

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getYearsAtCompany() {
        return yearsAtCompany;
    }


    // =========================================================
    // @Overrides
    // =========================================================

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName +
                " has worked for " + this.companyName + " for " +
                this.yearsAtCompany + " year(s).";
    }
    
}
