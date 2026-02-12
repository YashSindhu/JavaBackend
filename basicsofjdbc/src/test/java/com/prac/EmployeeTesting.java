package com.prac;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;

public class EmployeeTesting {

    // Test single employee age validation
    @Test
    public void testValidAge() {
        EmployeeApp.Employee e = new EmployeeApp.Employee(1, "Aman", 22, 50000, "2020-01-01", "CSE");
        EmployeeApp.EmployeeService service = new EmployeeApp.EmployeeService();

        assertTrue(service.isValidAge(e));
    }

    @Test
    public void testInvalidAge() {
        EmployeeApp.Employee e = new EmployeeApp.Employee(2, "Sam", 17, 45000, "2020-05-11", "IT");
        EmployeeApp.EmployeeService service = new EmployeeApp.EmployeeService();

        assertFalse(service.isValidAge(e));
    }

    // Test all employees valid age > 18
    @Test
    public void testValidAllEmployees() {
        List<EmployeeApp.Employee> list = Arrays.asList(
                new EmployeeApp.Employee(1, "Aman", 22, 50000, "2020-01-01", "CSE"),
                new EmployeeApp.Employee(2, "Riya", 24, 60000, "2019-03-12", "ECE"),
                new EmployeeApp.Employee(3, "Pavan", 30, 70000, "2018-09-21", "IT"),
                new EmployeeApp.Employee(4, "John", 26, 55000, "2021-11-10", "ME"),
                new EmployeeApp.Employee(5, "Karan", 20, 45000, "2022-07-15", "CIVIL")
        );

        assertTrue(EmployeeApp.EmployeeService.isValidAllEmployees(list));
    }

    // Test when one employee is invalid
    @Test
    public void testInvalidAllEmployees() {
        List<EmployeeApp.Employee> list = Arrays.asList(
                new EmployeeApp.Employee(1, "Aman", 22, 50000, "2020-01-01", "CSE"),
                new EmployeeApp.Employee(2, "Riya", 16, 60000, "2019-03-12", "ECE") // invalid age
        );

        assertFalse(EmployeeApp.EmployeeService.isValidAllEmployees(list));
    }

    // Test empty list
    @Test
    public void testListEmpty() {
        List<EmployeeApp.Employee> list = new ArrayList<>();
        assertTrue(EmployeeApp.EmployeeService.isListEmpty(list));
    }

    // Test non-empty list
    @Test
    public void testListNotEmpty() {
        List<EmployeeApp.Employee> list = Arrays.asList(
                new EmployeeApp.Employee(1, "Aman", 22, 50000, "2020-01-01", "CSE")
        );

        assertFalse(EmployeeApp.EmployeeService.isListEmpty(list));
    }
}
