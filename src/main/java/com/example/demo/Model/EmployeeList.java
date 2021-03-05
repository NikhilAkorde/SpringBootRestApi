package com.example.demo.Model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
	private List<EmployeeData> employeeList;

	public List<EmployeeData> getEmployeeList() {
		if (employeeList == null) {
			employeeList = new ArrayList<>();
		}
		return employeeList;
	}

	public void setEmployeeList(List<EmployeeData> employeeList) {
		this.employeeList = employeeList;
	}

}
