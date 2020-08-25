package com.empmanagement.config;
 
import java.util.List;
 
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.empmanagement.model.Employee;
 
public interface EmployeeMapper 
{
	
 @Insert("INSERT INTO EMPLOYEE(NAME, DESIGNATION, OFFICE) VALUES(#{name}, #{designation}, #{office})")
 @Options(useGeneratedKeys=true, keyProperty="id")
 public void insertEmployee(Employee blog);
 
 @Select("SELECT ID AS Id, NAME as name, DESIGNATION as designation, OFFICE as office FROM EMPLOYEE WHERE ID=#{id}")
 public Employee getEmployeeById(Integer id);
 
 @Select("SELECT * FROM EMPLOYEE")
 @Results({
  @Result(id=true, property="id", column="ID"),
  @Result(property="name", column="NAME"),
  @Result(property="designation", column="DESIGNATION"),
  @Result(property="office", column="OFFICE")  
 })
 public List<Employee> getAllEmployees();
 
 @Update("UPDATE EMPLOYEE SET NAME=#{name}, DESIGNATION=#{designation}, OFFICE=#{office} WHERE ID=#{id}")
 public int updateEmployee(Employee emp);
 
 @Delete("DELETE FROM EMPLOYEE WHERE ID=#{id}")
 public int deleteEmployee(Integer empId);
 
}