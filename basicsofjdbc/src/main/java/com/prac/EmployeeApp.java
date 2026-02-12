package com.prac;

import java.util.*;

public class EmployeeApp {

    	static class Employee {
    		private int id;
    		private String name;
    		private int age;
    		private double salary;
    		private String doj;
    		private String branch;

    		public Employee(int id, String name, int age, double salary, String doj, String branch) {
    			this.id = id;
    			this.name = name;
    			this.age = age;
    			this.salary = salary;
    			this.doj = doj;
    			this.branch = branch;
    		}

    		public int getAge() { return age; }
    		public double getSalary() { return salary; }
    		public String getBranch() { return branch; }
    		public String getDoj() { return doj; }

    		@Override
    		public String toString() {
    			return id + " - " + name + " - Age:" + age + " - Salary:" + salary + " - DOJ:" + doj + " - Branch:" + branch;
    		}
    }

    	static class EmployeeService {

    		public boolean isValidAge(Employee e) {
    			return e.getAge() > 18;
    		}

        // Validate ALL employees (age > 18)
    		public static boolean isValidAllEmployees(List<Employee> list) {
    			for (Employee e : list) {
    				if (e.getAge() <= 18) {
    					return false; // if ANY employee is invalid
    				}
    			}
    			return true;
    		}

        // Check list empty
    		public static boolean isListEmpty(List<Employee> list) {
    			return list == null || list.isEmpty();
    		}
    	
    }

    public static void main(String[] args) {

        List<Employee> list = Arrays.asList(
                new Employee(1, "Aman", 22, 50000, "2020-01-01", "CSE"),
                new Employee(2, "Riya", 24, 60000, "2019-03-12", "ECE"),
                new Employee(3, "Pavan", 30, 70000, "2018-09-21", "IT"),
                new Employee(4, "John", 26, 55000, "2021-11-10", "ME"),
                new Employee(5, "Karan", 20, 45000, "2022-07-15", "CIVIL")
        );

        System.out.println("List Empty? " + EmployeeService.isListEmpty(list));
        System.out.println("All Employees Age > 18? " + EmployeeService.isValidAllEmployees(list));

        for (Employee e : list) {
            System.out.println(e);
        }
    }
}

