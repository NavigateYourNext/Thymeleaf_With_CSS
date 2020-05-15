package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController 
{
	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData()
	{
		Employee theEmployee1 = new Employee(1,"Akshay","Shete","akshay@gmail.com");
		Employee theEmployee2 = new Employee(2,"Pradip","Shete","pradip@gmail.com");
		Employee theEmployee3 = new Employee(3,"Sangita","Shete","sangita@gmail.com");
		
		theEmployees = new ArrayList<>();
		
		theEmployees.add(theEmployee1);
		theEmployees.add(theEmployee2);
		theEmployees.add(theEmployee3);
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel)
	{
		theModel.addAttribute("employees",theEmployees);
		
		return "list-employees";
	}
	
	
}
