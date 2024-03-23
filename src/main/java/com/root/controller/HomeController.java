package com.root.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.root.entity.Employe;
import com.root.service.EmployeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private EmployeService empService;

	@GetMapping("/")
	public String indexPage(Model m) {

		List<Employe> list = empService.getAllEmp();

		m.addAttribute("empList", list);

		return "index";
	}

	@GetMapping("/loadEmpSave")
	public String saveEmpPage() {

		return "emp_save";
	}

	@GetMapping("/edit_emp/{id}")
	public String editEmp(@PathVariable int id, Model m) {

//		System.out.println(id);

		Employe emp = empService.getEmpById(id);

		m.addAttribute("empEdited", emp);

		return "edit_emp";
	}

	@PostMapping("/actionEmp")
	public String saveEmp(@ModelAttribute Employe emp, HttpSession session) {

		Employe savedEmp = empService.saveEmp(emp);

		if (savedEmp != null) {

			session.setAttribute("msg", "Register Sucessfully...!");
		} else {
			session.setAttribute("msg", "Something wrong on Server..!");
		}

		return "redirect:/loadEmpSave";
	}

	@PostMapping("/updateEmp")
	public String updateEmp(@ModelAttribute Employe emp, HttpSession session) {

		Employe updateEmp = empService.saveEmp(emp);

		if (updateEmp != null) {

			session.setAttribute("msg", "Updated Sucessfully...!");
		} else {
			session.setAttribute("msg", "Something wrong on Server..!");
		}

		return "redirect:/";
	}

	@GetMapping("/deleteEmp/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session) {

		boolean f = empService.deleteEmp(id);

		if(f) {

			session.setAttribute("msg", "Delete Sucessfully...!");
		} else {
			session.setAttribute("msg", "Something wrong on Server..!");
		}
		
		return "redirect:/";
	}
}
