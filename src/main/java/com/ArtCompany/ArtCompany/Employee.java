package com.ArtCompany.ArtCompany;

import java.util.Objects;

public class Employee {

    private final String employeeFirstName;
    private final String employeeLastName;

    public Employee(String employeeLastName, String employeeFirstName) {
        this.employeeLastName = employeeLastName;
        this.employeeFirstName = employeeFirstName;
    }

    // Геттеры
    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    //String
    public String toString() {
        return " | ФИО: " + employeeLastName + " " + employeeFirstName + " ";
    }

    // Equals и hascode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeFirstName, employee.employeeFirstName)
                && Objects.equals(employeeLastName, employee.employeeLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeFirstName, employeeLastName);
    }
}
