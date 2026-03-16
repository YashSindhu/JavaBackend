package com.prac.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prac.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartment(String department);

    List<Employee> findBySalaryGreaterThan(Double salary);

    @Query("SELECT e FROM Employee e WHERE e.salary > (SELECT AVG(e2.salary) FROM Employee e2)")
    List<Employee> findSalaryAboveAverage();

}