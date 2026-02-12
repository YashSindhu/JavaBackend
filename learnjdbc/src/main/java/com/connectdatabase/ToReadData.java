package com.connectdatabase;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ToReadData {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/college";
	    String un = "postgres";
	    String pwd = "root";
	    
	    Scanner sc = new Scanner(System.in);
	    
	    try {
			Class.forName("org.postgresql.Driver");
			
			Connection connect = DriverManager.getConnection(url,un,pwd);
			
			String sql = "INSERT INTO student values(?,?,?)";
			PreparedStatement pstm = connect.prepareStatement(sql);
			System.out.print("Enter Id: ");
			int id = sc.nextInt();
			pstm.setInt(1, id);
			
			System.out.println();
			System.out.print("Enter Name: ");
			String name = sc.next();
			pstm.setString(2, name);
			
			System.out.println();
			System.out.print("Enter branch: ");
			String branch = sc.next();
			pstm.setString(3, branch);
			
			pstm.execute();
			System.out.println("Data Inserted");
			
			connect.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
