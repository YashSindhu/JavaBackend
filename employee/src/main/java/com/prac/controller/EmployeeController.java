package com.prac.controller;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prac.entity.Employee;
import com.prac.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService service;

	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@PostMapping
	public Employee create(@RequestBody Employee employee) {
		return service.createEmployee(employee);
	}

	@GetMapping
	public List<Employee> getAll() {
		return service.getAllEmployees();
	}

	@GetMapping("/{id}")
	public Employee getById(@PathVariable Long id) {
		return service.getEmployeeById(id);
	}

	@PutMapping("/{id}")
	public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
		return service.updateEmployee(id, employee);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteEmployee(id);
	}

	@GetMapping("/department/{name}")
	public List<Employee> byDepartment(@PathVariable String name) {
		return service.getByDepartment(name);
	}

	@GetMapping("/highsalary")
	public List<Employee> highSalary(@RequestParam Double salary) {
		return service.getHighSalary(salary);
	}

	@GetMapping("/count")
	public long count() {
		return service.countEmployees();
	}

	@GetMapping("/sort")
	public List<Employee> sort() {
		return service.sortBySalary();
	}

	@GetMapping("/page")
	public Page<Employee> page(@RequestParam int page, @RequestParam int size) {
		return service.paginate(page, size);
	}

	@GetMapping("/above-average")
	public List<Employee> aboveAverage() {
		return service.salaryAboveAverage();
	}
}