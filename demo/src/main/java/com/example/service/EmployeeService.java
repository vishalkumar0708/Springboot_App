package com.example.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeRepository;
import com.example.entity.Employee;
import com.example.entity.TaxDetails;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public ResponseEntity<TaxDetails> calculateTaxDeductions(Integer employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
                .orElse(null);

        double yearlySalary = calculateYearlySalary(employee);
        double tax = calculateTax(yearlySalary);
        double cess = calculateCess(yearlySalary);

        TaxDetails taxDeduction = new TaxDetails(employeeId, employee.getFirstName(), employee.getLastName(),
                yearlySalary, tax, cess);

        return ResponseEntity.ok(taxDeduction);
		
	}
	
	private double calculateYearlySalary(Employee employee) {
        LocalDate currentDate = LocalDate.now();
        int monthsWorked = 12 - employee.getDoj().getMonthValue() + (currentDate.getMonthValue() - 1);
        // Handle cases where current month is before employee's DOJ month
        if (monthsWorked <= 0) {
            monthsWorked = 12 + monthsWorked;
        }
        double totalSalary = employee.getSalary() * monthsWorked;

        // Adjust for loss of pay within the first month
        if (employee.getDoj().getDayOfMonth() != 1) {
            double lossOfPay = employee.getSalary() / 30 * (employee.getDoj().getDayOfMonth() - 1);
            totalSalary -= lossOfPay;
        }

        return totalSalary;
    }

    private double calculateTax(double yearlySalary) {
        if (yearlySalary <= 250000) {
            return 0;
        } else if (yearlySalary <= 500000) {
            return 0.05 * (yearlySalary - 250000);
        } else if (yearlySalary <= 1000000) {
            return 12500 + 0.1 * (yearlySalary - 500000);
        } else {
            return 12500 + 50000 + 0.2 * (yearlySalary - 1000000);
        }
    }

    private double calculateCess(double yearlySalary) {
        if (yearlySalary > 2500000) {
            return 0.02 * (yearlySalary - 2500000);
        } else {
            return 0;
        }
    }
}
