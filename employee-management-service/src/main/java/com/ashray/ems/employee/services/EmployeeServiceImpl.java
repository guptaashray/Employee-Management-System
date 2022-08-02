package com.ashray.ems.employee.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ashray.ems.employee.entity.Employee;
import com.ashray.ems.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		Employee returnEmployee = employeeRepository.saveAndFlush(employee);
		return returnEmployee;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		
		List<Employee> allEmployees = employees
				.stream()
				.map(emp -> new Employee(
						emp.getId(),
						emp.getFirstName(),
						emp.getLastName(),
						emp.getEmailId(),
						emp.getMobile()))
				.collect(Collectors.toList());
		
		return allEmployees;
	}
	
	@Override
	public boolean deleteEmployee(Long id) {
		Employee employee = employeeRepository.findById(id).get();
		employeeRepository.delete(employee);
		return true;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id).get();
		Employee newEmp = new Employee();
		BeanUtils.copyProperties(employee, newEmp);
		return employee;
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Employee oldEmployee = employeeRepository.findById(id).get();
		oldEmployee.setEmailId(employee.getEmailId());
		oldEmployee.setFirstName(employee.getFirstName());
		oldEmployee.setLastName(employee.getLastName());
		oldEmployee.setMobile(employee.getMobile());
		
		employeeRepository.saveAndFlush(oldEmployee);
		
		return employee;
	}
	

}
