package com.employeeregistration.dto;

public class SalarySummary {
    private double totalSalary;
    private double averageSalary;
    private int employeeCount;

    public SalarySummary(double totalSalary, double averageSalary, int employeeCount) {
        this.totalSalary = totalSalary;
        this.averageSalary = averageSalary;
        this.employeeCount = employeeCount;
    }

    // getters
    public double getTotalSalary() { return totalSalary; }
    public double getAverageSalary() { return averageSalary; }
    public int getEmployeeCount() { return employeeCount; }
}
