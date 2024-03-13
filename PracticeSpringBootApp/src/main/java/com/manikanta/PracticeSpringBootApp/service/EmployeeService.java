package com.manikanta.PracticeSpringBootApp.service;

import java.util.List;

import com.manikanta.PracticeSpringBootApp.entity.Employee;

public interface EmployeeService {
	public Employee saveEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public Employee getOneEmployee(Long empId);
	public List<Employee> getAllEmployee();
	public void deleteEmployee(Long id);
	
	
	
	

}
