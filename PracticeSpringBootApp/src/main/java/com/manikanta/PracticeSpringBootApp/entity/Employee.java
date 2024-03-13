package com.manikanta.PracticeSpringBootApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long empId;
    @Column(name="EmployeeId")
	private String empName;
    @Column(name="EmployeeTechnology")
	private String empTechnology;
    @Column(name="EmployeeSalary")
	private float empSalary;

	public Employee() {
		super();
	}

	public Employee(Long empId, String empName, String empTechnology, float empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empTechnology = empTechnology;
		this.empSalary = empSalary;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpTechnology() {
		return empTechnology;
	}

	public void setEmpTechnology(String empTechnology) {
		this.empTechnology = empTechnology;
	}

	public float getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empTechnology=" + empTechnology + ", empSalary="
				+ empSalary + "]";
	}


}
