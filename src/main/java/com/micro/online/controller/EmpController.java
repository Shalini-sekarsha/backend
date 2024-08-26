package com.micro.online.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.online.model.Emp;
import com.micro.online.serviceimpl.EmpServiceImpl;


@RestController
@RequestMapping("/emp")
@CrossOrigin("http://localhost:3000")
public class EmpController {
	@Autowired
	EmpServiceImpl service;

	@PostMapping("/insertEmp")
	public String insertEmp(@RequestBody Emp e)

	{
		String msg = "";

		try {
			service.addEmp(e);
			msg = " add Success";
		} catch (Exception s) {

			msg = " add Failure";
		}

		return msg;
	}

	@GetMapping("{id}")
	public Emp getEmployeeById(@PathVariable("id") int id) {
		return service.getEmp(id);

	}

	@GetMapping("/all")
	public List<Emp> getEmp() {
		return service.getAllEmp();

	}

	@PutMapping
	public String updateEmp(@RequestBody Emp e)

	{
		String msg = "";

		try {
			service.updateEmp(e);
			msg = "update Success";
		} catch (Exception s) {

			msg = "update Failure";
		}

		return msg;
	}

	@DeleteMapping("{id}")
	public String deleteEmp(@PathVariable("id") int id)

	{
		String msg = "";

		try {
			service.deleteEmp(id);
			msg = "del Success";
		} catch (Exception s) {

			msg = "del Failure";
		}

		return msg;
	}

}

