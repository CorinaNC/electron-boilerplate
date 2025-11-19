package com.giratina.backend.models;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;


@Builder
@Document(value = "employees")
public class Employee {
    private String id;
    private String employeeName;
    private String location;
    private Double salary;

    public Employee(String id, String employeeName, String location, Double salary) {
        this.id = id;
        this.employeeName = employeeName;
        this.location = location;
        this.salary = salary;
    }

    // Getters and Setters (CRITICAL - without these, JSON serialization fails)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    // toString method for debugging
    @Override
    public String toString() {
        return "Employee{id='" + id + "', employeeName='" + employeeName + "', location='" + location + "', salary=" + salary + "}";
    }
}
