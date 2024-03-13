package com.manikanta.PracticeSpringBootApp.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manikanta.PracticeSpringBootApp.entity.Employee;
import com.manikanta.PracticeSpringBootApp.exception.ResourceNotFoundException;
import com.manikanta.PracticeSpringBootApp.serviceImpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl ss;

	@PostMapping("/addEmployee")
	public ResponseEntity<Object> saveEmployee(@RequestBody Employee employee) {
		try {
			Employee savedEmployee = ss.saveEmployee(employee);
			return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to add employee: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateEmployee")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
		try {
			Employee updatedEmployee = ss.saveEmployee(employee);
			return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to update employee: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/EmployeeById/{id}")
	public ResponseEntity<Object> getOneEmployee(@PathVariable("id") Long empId) {
		try {
			Employee employee = ss.getOneEmployee(empId);
			return new ResponseEntity<>(employee, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Employee not found with id: " + empId, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>("Error fetching employee: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getAll")
	public ResponseEntity<Object> getAllEmployee() {
		try {
			List<Employee> employees = ss.getAllEmployee();
			return new ResponseEntity<>(employees, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error fetching employees: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Long empId) {
		try {
			ss.deleteEmployee(empId);
			return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>("Error fetching employees: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
