package com.empmanagement;
 
import java.util.List;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.empmanagement.model.Employee;
import com.empmanagement.service.EmployeeService;
import com.empmanagement.service.EmployeeServiceImpl;
import com.empmanagement.dao.EmployeeDAOImpl;
 
 
@Path("/employees")
public class MyResource {
 
    @GET
    @Produces("application/json")
    public List<Employee> getEmployees() {
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        List employees = service.getEmployees();
        return employees;
    }
 
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Employee getEmployee(@PathParam("id") int id) {
        
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        Employee employee = service.getEmployee(id);
        return employee;
    }
    
    @POST
    @Path("/create")
    @Consumes("application/json")
    public Response addEmployee(Employee emp){  
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        service.addEmployee(emp);
        return Response.ok().build();
    }
    
    @PUT
    @Path("/update/{id}")
    @Consumes("application/json")
    public Response updateEmployee(@PathParam("id") int id, Employee emp){
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        Response res = service.updateEmployee(id, emp);
        return res;
    }
    
    @DELETE
    @Path("/delete/{id}")
    @Consumes("application/json")
    public Response deleteEmployee(@PathParam("id") int id){
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        Response res = service.deleteEmployee(id);
        return res;
    }
}