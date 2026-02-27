package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.dto.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao dao;
	public void insertEmployee(Employee e) {
		if(dao.find(e.getId()) == null) {
			dao.insertEmp(e);
		}else {
			System.out.println("Data exist");
		}
	}
}
