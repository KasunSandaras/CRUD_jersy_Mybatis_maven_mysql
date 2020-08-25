package com.empmanagement.service;

import java.util.List;

import javax.ws.rs.core.Response;

import com.empmanagement.model.Employee;

public interface EmployeeService {

	public void addEmployee(Employee bean);
	
	public List<Employee> getEmployees();
	
	public Employee getEmployee(int id);
	
	public Response deleteEmployee(int id);
	
    public Response updateEmployee(int id, Employee emp);
}
