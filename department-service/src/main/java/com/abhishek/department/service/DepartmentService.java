package com.abhishek.department.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.abhishek.department.entity.Department;
import com.abhishek.department.repository.DepartmentRepository;

@Service
public class DepartmentService {
	private final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DepartmentService.class);
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		log.info("Inside saveDepartment method in Department Service!!");
		log.info(department.getDepartmentName());
		return departmentRepository.save(department);
	}

	public Optional<Department> findDepartmentById(Long departmentId) {
		log.info("Inside findDepartmentByIdmethod in Department Service!!");
		log.info(departmentId.toString());
		return departmentRepository.findByDepartmentId(departmentId);
	}

}
