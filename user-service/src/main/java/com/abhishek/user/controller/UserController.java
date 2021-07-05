package com.abhishek.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.user.VO.ResponseTemplateVO;
import com.abhishek.user.entity.User;
import com.abhishek.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("Inside saveUser method in UserController!!");
		return userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long  userId) {
		log.info("Inside getUserWithDepartment method in UserController!!");
		return userService.getUserWithDepartment(userId);
		
	}
	

}
