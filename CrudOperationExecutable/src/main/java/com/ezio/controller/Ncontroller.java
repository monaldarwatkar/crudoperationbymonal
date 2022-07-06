package com.ezio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.ezio.model.Nmodel;
import com.ezio.service.Nservice;

@Controller
public class Ncontroller {

	@Autowired
	Nservice service;

	@GetMapping("/")
	public String show(Model model) {
		model.addAttribute("listEmployees", service.getAllEmployees());
		return "index";

	}

	@GetMapping("/showNewEmployee")
	public String showNewEmployee(Model model)

	{
		Nmodel employee = new Nmodel();
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Nmodel employee)
	{
		service.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id")long id,Model model)
	{
		Nmodel employee=service.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "update_employee";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value="id")long id,Model model)
	{
		this.service.deleteEmployeeByID(id);
		return "redirect:/";
	}

}
