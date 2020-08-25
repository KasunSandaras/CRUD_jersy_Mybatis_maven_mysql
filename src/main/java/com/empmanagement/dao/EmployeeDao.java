package com.empmanagement.dao;

import java.util.List;

import com.empmanagement.model.Employee;

public interface EmployeeDao {
	
	public void addEmployee(Employee bean);
	
	public List<Employee> getEmployees();
	
	public Employee getEmployee(int id);
	
	public int deleteEmployee(int id);
	
    public int updateEmployee(int id, Employee emp);
}
