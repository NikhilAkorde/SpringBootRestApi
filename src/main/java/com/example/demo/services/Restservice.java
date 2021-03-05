package com.example.demo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.Model.EmployeeData;
import com.example.demo.Model.EmployeeList;

@Service
public class Restservice {
  private static EmployeeList employeeLists = new EmployeeList();
	
	/*
	 * static { employeeLists.getEmployeeList().add(new
	 * EmployeeData("nikhil","1755","Junior officer","Development"));
	 * employeeLists.getEmployeeList().add(new EmployeeData("Sagar", "1756",
	 * "executive", "Development")); }
	 */
  
	/*
	 * private List<EmployeeData> empdata = new ArrayList<>( Arrays.asList(new
	 * EmployeeData("nikhil","1755","Junior officer","Development"), new
	 * EmployeeData("Sagar", "1756", "executive", "Development") ));
	 */
 
 public EmployeeList employeeList()
 {
	 System.out.println(employeeLists);
	 return employeeLists;
 }

public void addEmployees(EmployeeData employeeData) {
	employeeLists.getEmployeeList().add(employeeData);
}
}
