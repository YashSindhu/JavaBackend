package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// Whichever class is there in lang we dont have to use import
public class StepsToConnectDataBase {
	
	
	
	public static void main(String[] args) {
		// Load the driver class
		String url = "jdbc:postgresql://localhost:5432/college";
		String un = "postgres";
		String pwd = "root";
		
		try {
		// load driver
			Class.forName("org.postgresql.Driver");
			
		// To establish connection
			
			
			Connection con = DriverManager.getConnection(url, un, pwd);
			String sql = "INSERT INTO STUDENT VALUES(2,'Yash','CSE')";
			String sql1 = "UPDATE STUDENT SET name = 'JAAT' WHERE id = 1";
			String sql2 = "DELETE FROM STUDENT WHERE id = 2";
			String sql3 = "CREATE TABLE stu(id integer PRIMARY KEY, name varchar(20))";
//			String sql4 = "SELECT * FROM student";
			
		// Create stmt
			
			Statement stmt = con.createStatement();
			
		// Execute query
			
			stmt.execute(sql3);
//			stmt.executeQuery(sql4);
			
		// close connection
			
			System.out.println("Connection created");
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
