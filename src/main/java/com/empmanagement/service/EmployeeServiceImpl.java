package com.empmanagement.service;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.core.Response;

import com.empmanagement.dao.EmployeeDAOImpl;
import com.empmanagement.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public void addEmployee(Employee emp) {
		emp.setName(emp.getName());
        emp.setDesignation(emp.getDesignation());
        emp.setOffice(emp.getOffice());
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
        dao.addEmployee(emp);
	}

	@Override
	public List<Employee> getEmployees() {
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
        return (dao.getEmployees());
	}

	@Override
	public Employee getEmployee(int id) {
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
		return (dao.getEmployee(id));
	}

	@Override
	public Response deleteEmployee(int id) {
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
        int count = dao.deleteEmployee(id);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
	}

	@Override
	public Response updateEmployee(int id, Employee emp) {
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
        int count = dao.updateEmployee(id, emp);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
	}
}
