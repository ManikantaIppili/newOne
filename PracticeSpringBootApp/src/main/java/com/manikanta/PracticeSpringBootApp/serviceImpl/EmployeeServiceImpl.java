package com.manikanta.PracticeSpringBootApp.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.manikanta.PracticeSpringBootApp.entity.Employee;
import com.manikanta.PracticeSpringBootApp.exception.ResourceNotFoundException;
import com.manikanta.PracticeSpringBootApp.repository.EmployeeRepository;
import com.manikanta.PracticeSpringBootApp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository repo;
	
	public Employee saveEmployee(Employee employee) {
        try {
            return repo.save(employee);
        } catch (DataAccessException e) {
            // Handle database-specific exceptions
            throw new ServiceException("Failed to save employee to the database", e);
        }
    }
	
	 @Override
	    public Employee updateEmployee(Employee employee) {
	        try {
	            return repo.save(employee);
	        } catch (DataAccessException e) {
	            throw new ServiceException("Failed to update employee in the database", e);
	        }
	    }

	 public Employee getOneEmployee(Long empId) {
	        try {
	            return repo.findById(empId).orElseThrow();
	        } catch (NoSuchElementException e) {
	            throw new ResourceNotFoundException("Employee not found with id: " + empId);
	        } catch (DataAccessException e) {
	            throw new ServiceException("Failed to retrieve employee from the database", e);
	        } catch (Exception e) {
	            throw new ServiceException("Unexpected error while retrieving employee", e);
	        }
	    }
	    @Override
	    public List<Employee> getAllEmployee() {
	        try {
	            return repo.findAll();
	        } catch (DataAccessException e) {
	            throw new ServiceException("Failed to retrieve employees from the database", e);
	        }
	    }

	    @Override
	    public void deleteEmployee(Long empId) {
	        try {
	            repo.deleteById(empId);
	        } catch (EmptyResultDataAccessException e) {
	            throw new ResourceNotFoundException("Employee not found with id: " + empId);
	        } catch (DataAccessException e) {
	            throw new ServiceException("Failed to delete employee from the database", e);
	        }

	/*
	 * @Override public Employee saveEmployee(Employee employee) { return
	 * repo.save(employee); }
	 * 
	 * 
	 * @Override public Employee updateEmployee(Employee employee) { return
	 * repo.save(employee); }
	 * 
	 * @Override public Employee getOneEmployee(Long empId) { return
	 * repo.findById(empId).get(); }
	 * 
	 * @Override public List<Employee> getAllEmployee() { return repo.findAll(); }
	 * 
	 * @Override public void deleteEmployee(Long empId) { repo.deleteById(empId); }
	 */
	
	
	    }
}
