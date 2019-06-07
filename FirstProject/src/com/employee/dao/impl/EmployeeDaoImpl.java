package com.employee.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.employee.bean.EmployeeBean;
import com.employee.dao.EmployeeDao;
import com.employee.entity.EmployeeEntity;
import com.employee.util.DatabaseConnection;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public ArrayList<EmployeeEntity> getAllEmployee() {
		Connection conn = null;
		Statement stm = null;
		EmployeeEntity employeeEntity=null;
		ArrayList<EmployeeEntity> employeeList=new ArrayList<EmployeeEntity>();
		try {
		 conn = DatabaseConnection.getMySqlConnection();
		 stm = conn.createStatement();
		 String sql="SELECT * FROM employee";
		 ResultSet rs =stm.executeQuery(sql);
		 while(rs.next())
		 {
			 int id = rs.getInt(1);
			 String name =rs.getString(2);
			 int age = rs.getInt(3);
			 employeeEntity =new EmployeeEntity(id,name,age);
			 employeeList.add(employeeEntity);
		 }
		
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return employeeList;
	}

	@Override
	public void createEmployee(EmployeeEntity employeeEntity) {
		Connection conn = null;
		Statement stm = null;
		try {
			 conn = DatabaseConnection.getMySqlConnection();
			 stm = conn.createStatement();
			 String name =employeeEntity.getName();
			 int id = employeeEntity.getId();
			 int age = employeeEntity.getAge();
			 
			 String sql ="INSERT INTO employee(id,name,age) value("+id+",'"+name+"',"+age+")";
			 boolean isInserted =stm.execute(sql);
			 System.out.println(isInserted);
			 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	@Override
	public void deleteEmployeeById(int employeeId) {
		Connection conn = null;
		Statement stm = null;
		try {
			 conn = DatabaseConnection.getMySqlConnection();
			 stm = conn.createStatement();
			
			 
			 String sql ="DELETE FROM employee WHERE ID="+employeeId;
			 boolean isDeleted =stm.execute(sql);
			 System.out.println(isDeleted);
			 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmployeeEntity getEmployeeById(int employeeId) {
		Connection conn = null;
		Statement stm = null;
		EmployeeEntity employeeEntity=null;
		try {
		 conn = DatabaseConnection.getMySqlConnection();
		 stm = conn.createStatement();
		 String sql="SELECT * FROM employee WHERE id = "+employeeId;
		 ResultSet rs =stm.executeQuery(sql);
		 while(rs.next())
		 {
			 int id = rs.getInt(1);
			 String name =rs.getString(2);
			 int age = rs.getInt(3);
			 employeeEntity =new EmployeeEntity(id,name,age);
		 }
		
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return employeeEntity;
	}

	@Override
	public void updateEmployee(EmployeeEntity employeeEntity) {
		Connection conn = null;
		Statement stm = null;
		try {
			 conn = DatabaseConnection.getMySqlConnection();
			 stm = conn.createStatement();
			 String name =employeeEntity.getName();
			 int id = employeeEntity.getId();
			 int age = employeeEntity.getAge();
			 //UPDATE employee SET name='dibya',age=22 WHERE id=12;
			 
			 String sql ="UPDATE employee SET name = '" +name+"', age= "+age+" WHERE id ="+ id;
			 boolean isUpdated =stm.execute(sql);
			 System.out.println(isUpdated);
			 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
