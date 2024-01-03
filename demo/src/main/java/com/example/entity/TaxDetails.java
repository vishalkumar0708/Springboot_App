package com.example.entity;

public class TaxDetails {
	private Integer employeeId;
    private String firstName;
    private String lastName;
    private double yearlySalary;
    private double taxAmount;
    private double cessAmount;

    public TaxDetails(Integer employeeId, String firstName, String lastName, double yearlySalary, double taxAmount, double cessAmount) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearlySalary = yearlySalary;
        this.taxAmount = taxAmount;
        this.cessAmount = cessAmount;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public double getCessAmount() {
        return cessAmount;
    }
}
