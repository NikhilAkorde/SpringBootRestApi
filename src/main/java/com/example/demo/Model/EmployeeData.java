package com.example.demo.Model;

import java.util.List;

public class EmployeeData {
	private String name;
	private String empId;
	private String designation;
	private String department;
	private List<EmpAddress> empAddress;

	/*
	 * public EmployeeData(String name, String empId, String designation, String
	 * department) { System.out.println("model constructor"); this.name=name;
	 * this.empId=empId; this.designation=designation; this.department=department; }
	 */

	public EmployeeData(String name, String empId, String designation, String department, List<EmpAddress> empAddress) {
		super();
		this.name = name;
		this.empId = empId;
		this.designation = designation;
		this.department = department;
		this.empAddress = empAddress;
	}

	public String getName() {
		return name;
	}

	public List<EmpAddress> getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(List<EmpAddress> empAddress) {
		this.empAddress = empAddress;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
