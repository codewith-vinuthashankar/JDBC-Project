package org.jsp.employee_management_system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jsp.employee_management_system.connection.GetConnection;
import org.jsp.employee_management_system.entity.Employee;

public class EmployeeDao {
	
	Connection con=GetConnection.getConnectionObject();
//	design a method to insert data into database
	
	public boolean saveEmployee(Employee emp) {
		String insert="INSERT INTO employee VALUES(?,?,?,?,?)";
		try {
			PreparedStatement pstm=con.prepareStatement(insert);
			pstm.setInt(1, emp.getEid());
			pstm.setString(2, emp.getName());
			pstm.setString(3, emp.getEmail());
			pstm.setDouble(4, emp.getSalary());
			pstm.setInt(5, emp.getAge());
			int row=pstm.executeUpdate();
			return row > 0;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//Design a method to fetch all the employee layer 
	
	public List<Employee> getAllEmployee()
	{
		String selectQuery ="select * from employee";
		List<Employee> empList=new ArrayList<Employee>();
		try {
			PreparedStatement pstm=con.prepareStatement(selectQuery);
			ResultSet set=pstm.executeQuery();
			
			while(set.next())
			{
				int eid=set.getInt("eid");
				String name=set.getString("name");
				String email=set.getString("email");
				double salary=set.getDouble("salary");
				int age=set.getInt("age");
				
				//we have to bind in employee object
				Employee emp=new Employee();
				emp.setEid(eid);
				emp.setName(name);
				emp.setEmail(email);
				emp.setSalary(salary);
				emp.setAge(age);
				
				//add 
				empList.add(emp);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return empList;
	
	}
	
	
	//Design a method to fetch the employee record based on id
			public Employee getEmployeeById(int id)
			{
				String sql="select * from employee where empid=?";
				try {
					PreparedStatement pstm=con.prepareStatement(sql);
					pstm.setInt(1, id);
					ResultSet set=pstm.executeQuery();
					
					if(set.next())
					{
						int eid=set.getInt("eid");
						String name=set.getString("name");
						String email=set.getString("email");
						double salary=set.getDouble("salary");
						int age=set.getInt("age");
						
						//bind data into object
						Employee emp=new Employee();
						emp.setEid(id);
						emp.setName(name);
						emp.setEmail(email);
						emp.setSalary(salary);
						emp.setAge(age);
						
						return emp;
					}	
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				return null;		
			}
	
	// DeleteQuery based on Employee id
	public boolean deleteEmployeeById(int id) {
		String sql="delete from employee where eid=? ";
				
				try {
					PreparedStatement pstm = con.prepareStatement(sql);
					pstm.setInt(1,id);
					int row=pstm.executeUpdate();
					return row>0;
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				return false;
	}
// design a method to update employee name based on id
public boolean updateEmployeeById(int id, String name) {
	String updateQuery = "update employee set anme=? where eid=?";
	
	try {
		PreparedStatement pstm = con.prepareStatement(updateQuery);
		pstm.setString(1, name);
		pstm.setInt(2, id);
		int row=pstm.executeUpdate();
		return row>0;
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return false;
}

}





