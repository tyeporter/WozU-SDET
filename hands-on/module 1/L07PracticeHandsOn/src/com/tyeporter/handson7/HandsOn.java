package com.tyeporter.handson7;

import com.tyeporter.handson7.company.employee.*;

/***********************************************************
 * This hand-on practice demonstrates inheritance, 
 * polymorphism, and access modifiers
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-13-2020
 ***********************************************************/

public class HandsOn {

    public static void main(String[] args) {
        // Create 3 Employees
        Employee employee1 = new Employee();
        employee1.setFirstName("Bob");
        employee1.setLastName("Johnson");
        employee1.setCompanyName("Dell");
        employee1.setYearsAtCompany(10);
        Manager employee2 = new Manager("John", "Smith", "Google", 5, "Engineering Manager");
        Engineer employee3 = new Engineer("Jane", "Foster", "Facebook", 2, "Software Engineer");

        // Print their contents to the console
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);
    }
    
}
