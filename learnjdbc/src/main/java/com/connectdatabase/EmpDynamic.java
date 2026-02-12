package com.connectdatabase;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpDynamic {
	static Scanner sc = new Scanner(System.in);
	static String url = "jdbc:postgresql://localhost:5432/college" ;
	static String un = "postgres";
	static String pwd = "root";
	
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		while (true) {
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Find Employee by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> AddEmployee();
                case 2 -> DeleteEmpById();
                case 3 -> UpdateEmpSalById();
                case 4 -> FindEmpById();
                case 5 -> {
                    System.out.println("Exiting program... Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
	}
	public static void AddEmployee() throws SQLException {
		Connection connect = DriverManager.getConnection(url,un,pwd);
		String sql = "INSERT INTO employee values(?,?,?,?)";
		PreparedStatement pstm = connect.prepareStatement(sql);
		System.out.println("Enter Id: ");
		int id = sc.nextInt();
		pstm.setInt(1, id);
		
		System.out.println("Enter Name: ");
		String name = sc.next();
		pstm.setString(2,name);
		
		System.out.println("Enter Dept: ");
		String dept = sc.next();
		pstm.setString(3, dept);
		
		System.out.println("Enter Sal: ");
		int sal = sc.nextInt();
		pstm.setInt(4, sal);
		
		pstm.execute();
		
		System.out.println("Data inserted");
		connect.close();
		
	}
	public static void DeleteEmpById() throws SQLException{
		Connection connect = DriverManager.getConnection(url,un,pwd);
		String sql = "DELETE From employee Where id = ?";
		PreparedStatement pstm = connect.prepareStatement(sql);
		System.out.println("Enter Id: ");
		int id = sc.nextInt();
		pstm.setInt(1, id);
		pstm.execute();
		System.out.println("Data deleted");
		connect.close();
	}
	public static void UpdateEmpSalById() throws SQLException {
		Connection connect = DriverManager.getConnection(url,un,pwd);
		String sql = "Update employee Set sal = ? Where id = ?";
		PreparedStatement pstm = connect.prepareStatement(sql);
		System.out.println("Enter Sal: ");
		int sal = sc.nextInt();
		pstm.setInt(1, sal);
		
		System.out.println("Enter Id: ");
		int id = sc.nextInt();
		pstm.setInt(2, id);
		
		pstm.execute();
		System.out.println("Data Updated");
		connect.close();
	}
	public static void FindEmpById() throws SQLException{
		Connection connect = DriverManager.getConnection(url,un,pwd);
		String sql = "Select * FROM employee WHERE id = ?";
		PreparedStatement pstm = connect.prepareStatement(sql);
		System.out.println("Enter Id: ");
		int id = sc.nextInt();
		pstm.setInt(1, id);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
		    System.out.println("ID: " + rs.getInt(1));
		    System.out.println("Name: " + rs.getString(2));
		    System.out.println("Dept: " + rs.getString(3));
		    System.out.println("Salary: " + rs.getInt(4));
		} else {
		    System.out.println("Employee not found");
		}
		System.out.println("Employee details fetched");
	}
}
