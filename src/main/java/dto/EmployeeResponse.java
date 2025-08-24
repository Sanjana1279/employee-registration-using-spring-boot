package com.employeeregistration.dto;

public class EmployeeResponse {
    private Long id;
    private String name;
    private String username;
    private double salary;

    public EmployeeResponse(Long id, String name, String username, double salary) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.salary = salary;
    }

    // getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getUsername() { return username; }
    public double getSalary() { return salary; }
}
