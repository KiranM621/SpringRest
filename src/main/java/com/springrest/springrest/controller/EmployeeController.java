package com.springrest.springrest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.model.Employee;
import com.springrest.springrest.service.EmployeeService;


@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeservice;

	@GetMapping("/home")
	public String home() { 
	
		return "index";
	}
	
	@GetMapping("/getdata")
	public List<Employee> getData() { 
		
		return this.employeeservice.getData();
		
	}
	
	@GetMapping("/getdata/{id}")
	public Employee getById(@PathVariable("id") int id) { 
		
		return this.employeeservice.getById(id);
		
	}
	
	@PostMapping("/create")
	public Employee create(@RequestBody Employee employee) { 
		return this.employeeservice.create(employee);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable("id") int id) {
		
		this.employeeservice.deleteById(id);
	}
	
	@PutMapping("/updateById/{id}")
	public  Employee updateById(@PathVariable int id,@RequestBody Employee employee) {
		return this.employeeservice.updateById(id,employee);
	}
}

