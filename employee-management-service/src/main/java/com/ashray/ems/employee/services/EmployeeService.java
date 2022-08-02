package com.ashray.ems.employee.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ashray.ems.employee.entity.Employee;

@Service
public interface EmployeeService {
	
	Employee addEmployee(Employee employee);
	List<Employee> getEmployees();
	boolean deleteEmployee(Long id);
	Employee getEmployeeById(Long id);
	Employee updateEmployee(Long id, Employee employee);
}
