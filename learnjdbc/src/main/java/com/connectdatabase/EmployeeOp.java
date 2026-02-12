package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeOp {

    // connection details
    static String url = "jdbc:postgresql://localhost:5432/college";
    static String un = "postgres";
    static String pwd = "root";

    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");

            createEmployeeTable();
            insertEmployee(1, "Yash", "CSE", 50000);
            insertEmployee(2, "Abhinav", "IT", 45000);

            updateEmployeeName(1, "Yash Sindhu");

            deleteEmployee(2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ---------------- METHODS ---------------- //

    // 1️⃣ Create Table
    public static void createEmployeeTable() throws SQLException {
        Connection con = DriverManager.getConnection(url, un, pwd);
        Statement stmt = con.createStatement();

        String sql = "CREATE TABLE IF NOT EXISTS employee("
                   + "id INTEGER PRIMARY KEY, "
                   + "name VARCHAR(30), "
                   + "dept VARCHAR(20), "
                   + "salary INTEGER)";

        stmt.execute(sql);
        System.out.println("Employee table created successfully");

         con.close();
    }

    // 2️⃣ Insert Employee
    public static void insertEmployee(int id, String name, String dept, int salary) throws SQLException {
        Connection con = DriverManager.getConnection(url, un, pwd);
        Statement stmt = con.createStatement();

        String sql = "INSERT INTO employee VALUES(" 
                    + id + ", '" + name + "', '" + dept + "', " + salary + ")";

        stmt.execute(sql);
        System.out.println("Inserted: " + name);

        con.close();
    }

    // 3️⃣ Update Employee Name
    public static void updateEmployeeName(int id, String newName) throws SQLException {
        Connection con = DriverManager.getConnection(url, un, pwd);
        Statement stmt = con.createStatement();

        String sql = "UPDATE employee SET name = '" + newName + "' WHERE id = " + id;

        stmt.execute(sql);
        System.out.println("Updated Employee ID " + id);

        con.close();
    }

    // 4️⃣ Delete Employee
    public static void deleteEmployee(int id) throws SQLException {
        Connection con = DriverManager.getConnection(url, un, pwd);
        Statement stmt = con.createStatement();

        String sql = "DELETE FROM employee WHERE id = " + id;

        stmt.execute(sql);
        System.out.println("Deleted Employee ID " + id);

        con.close();
    }
}
