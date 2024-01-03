package com.example.controller;

import org.springframework.web.bind.annotation.*;

import com.example.entity.Employee;
import com.example.entity.TaxDetails;
import com.example.service.EmployeeService;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		// Validate the employee data
		if (employee.isValid()) {
			employeeService.createEmployee(employee);
			return new ResponseEntity<>("Employee added successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Invalid employee data", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/employees/{employeeId}/tax-deduction")
	public ResponseEntity<TaxDetails> getTaxDeduction(@PathVariable Integer employeeId)

	{
		return employeeService.calculateTaxDeductions(employeeId);
	}

}
