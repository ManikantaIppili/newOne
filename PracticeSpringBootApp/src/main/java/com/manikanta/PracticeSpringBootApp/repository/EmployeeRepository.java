package com.manikanta.PracticeSpringBootApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manikanta.PracticeSpringBootApp.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	

}
