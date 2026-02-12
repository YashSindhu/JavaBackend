package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindStudentData {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/college";
		String un = "postgres";
		String pwd = "root";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection conn = DriverManager.getConnection(url,un,pwd);
			
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT * FROM student";
			
			ResultSet res=stmt.executeQuery(sql);
			while(res.next()) {
				System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
