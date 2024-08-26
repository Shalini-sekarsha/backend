package com.micro.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.online.model.Employee;
import com.micro.online.service.EmployeeService;

@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService emplopyeeservice;

	@PostMapping("/doemployeeinsert")
	public Employee insertEmployee(@RequestBody Employee newEmployee) {
		return emplopyeeservice.newEmployee(newEmployee);

	}

	@PutMapping("/updateemployee")
	public Employee updateEmployee(@RequestBody Employee employee) {

		return emplopyeeservice.updateEmployee(employee);
	}

	@GetMapping("/getallEmployeeList")
	public List<Employee> getEmployees() {
		return emplopyeeservice.getEmployees();
	}

	@GetMapping("/getempid/{empId}")
	public Employee appfind(@PathVariable("empId") int empId) {
		return emplopyeeservice.employeefind(empId);
	}

	@GetMapping("/loginemployee/{empName}/{empPassword}")
	public boolean loginemployee(@PathVariable("empName") String empName,
			@PathVariable("empPassword") String empPassword) {
		Employee existingEmployee = emplopyeeservice.findByEmpName(empName);
		try {
			if (existingEmployee != null && empPassword.equals(existingEmployee.getEmpPassword())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
}
