package com.empmanagement.dao;
 
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.empmanagement.config.EmployeeMapper;
import com.empmanagement.model.Employee;

import MyBatisUtil.MyBatisUtil;
 
public class EmployeeDAOImpl implements EmployeeDao{
    
    private Employee employee;

	public void addEmployee(Employee emp){
		
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
		  EmployeeMapper blogMapper = sqlSession.getMapper(EmployeeMapper.class);
		  blogMapper.insertEmployee(emp);
		  sqlSession.commit();
		  }finally{
		   sqlSession.close();
		  }    
    }
	
	public Employee getEmployee(int id) {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
		  EmployeeMapper blogMapper = sqlSession.getMapper(EmployeeMapper.class);
		  return blogMapper.getEmployeeById(id);
		  }finally{
		   sqlSession.close();
		  }
	}

	   public List<Employee> getEmployees(){
	    	
	    	SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
	    	  try{
	    	  EmployeeMapper blogMapper = sqlSession.getMapper(EmployeeMapper.class);
	    	  return blogMapper.getAllEmployees();
	    	  }finally{
	    	   sqlSession.close();
	    	  }
	    	
	    }
	
	@Override
	public int deleteEmployee(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  int rowCount;
		try{
			  EmployeeMapper blogMapper = sqlSession.getMapper(EmployeeMapper.class);
			  rowCount =blogMapper.deleteEmployee(id);
		  sqlSession.commit();
		  }finally{
		   sqlSession.close();
		  }
		  return rowCount;
	}

	@Override
	public int updateEmployee(int id, Employee emp) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  int rowCount;
		try{
		  EmployeeMapper empMapper = sqlSession.getMapper(EmployeeMapper.class);
		  rowCount = empMapper.updateEmployee(emp);
		  sqlSession.commit();
		  }finally{
		   sqlSession.close();
		  } 
		  return rowCount;
	}
}