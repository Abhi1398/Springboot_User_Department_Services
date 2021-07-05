package com.abhishek.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abhishek.user.VO.Department;
import com.abhishek.user.VO.ResponseTemplateVO;
import com.abhishek.user.controller.UserController;
import com.abhishek.user.entity.User;
import com.abhishek.user.repository.UserRepository;

@Service
public class UserService {
	private final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("Inside saveUser method in UserService!!");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("Inside saveUser method in UserService!!");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
		Department department =  restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),Department.class);
		
		vo.setUser(user);
		vo.setDepartment(department);
		
		return vo;
	}



}
