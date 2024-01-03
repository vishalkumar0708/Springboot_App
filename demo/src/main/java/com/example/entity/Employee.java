package com.example.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_employee")
public class Employee {
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeId;
	@Column(name="first_name")
    private String firstName;
	@Column(name="last_name")
    private String lastName;
    private String email;
    private List<String> phoneNumbers;
    private LocalDate doj; // Date of Joining
    private double salary;

    public boolean isValid() {
        // Validate the employee data...
        return true;
    }

 // Getter methods
    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public double getSalary() {
        return salary;
    }

    // Setter methods
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // toString method
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", doj=" + doj +
                ", salary=" + salary +
                '}';
    }
}
