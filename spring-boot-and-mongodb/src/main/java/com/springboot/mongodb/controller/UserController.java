package com.springboot.mongodb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongodb.dto.UserDto;
import com.springboot.mongodb.entity.UserEntity;
import com.springboot.mongodb.service.UserService;

/* 
 *Implemented by shailendra
*/

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public ResponseEntity<String> createUser(@Valid @RequestBody UserDto userDto) {
		userService.createUser(userDto);
		return new ResponseEntity<>("User created successfully !", HttpStatus.CREATED);
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getAllUser() {
		List<UserDto> userList = userService.getAllUser();
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("userId") String userId) {
		UserDto user = userService.getUserById(userId);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PutMapping("/users/{userId}")
	public ResponseEntity<String> updateUserById(@PathVariable("userId") String userId, @RequestBody UserDto userDto) {
		UserEntity user = userService.updateUserById(userId, userDto);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("User updated successfully !", HttpStatus.OK);
	}

	@DeleteMapping("/users/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable("userId") String userId) {
		if (userService.deleteUserById(userId)) {
			return new ResponseEntity<>("User deleted successfully !", HttpStatus.OK);
		}
		return new ResponseEntity<>("User does not exist for this id !", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/users")
	public ResponseEntity<String> deleteAllUser() {
		userService.deleteAllUser();
		return new ResponseEntity<>("All User deleted successfully !", HttpStatus.OK);

	}

}
