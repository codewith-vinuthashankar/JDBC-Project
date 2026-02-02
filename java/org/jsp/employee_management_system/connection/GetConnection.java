package org.jsp.employee_management_system.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
	
	public static Connection getConnectionObject() {
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems_db", "root", "root");
//		 it will return connection object whenever we are calling
		 return con;
		 
	 }
	 catch(Exception e) {
		 e.printStackTrace();
	 }
//	 it will return null if connection is not established
	 return null;
	}

}
