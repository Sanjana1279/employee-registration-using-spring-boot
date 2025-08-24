package com.employeeregistration.dto;

public class EmployeeRegisterRequest {
    private String name;
    private String username;
    private String password;
    private double salary;

    // getters & setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}
