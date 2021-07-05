package com.abhishek.department.controller;


import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.department.entity.Department;
import com.abhishek.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	 private final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("Inside saveDepartment method in Department Controller!!");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/{id}")
	public Optional<Department> findDepartmentById(@PathVariable("id") Long departmentId) {
		log.info("Inside findDepartmentByIdmethod in Department Controller!!");
		return departmentService.findDepartmentById(departmentId);
	}
	
}
