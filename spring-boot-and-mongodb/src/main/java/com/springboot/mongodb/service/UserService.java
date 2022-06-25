package com.springboot.mongodb.service;

import java.util.List;

import com.springboot.mongodb.dto.UserDto;
import com.springboot.mongodb.entity.UserEntity;

/* 
 *Implemented by shailendra
*/

public interface UserService {

	public UserEntity createUser(UserDto userDto);

	public List<UserDto> getAllUser();

	public UserDto getUserById(String userId);

	public UserEntity updateUserById(String userId, UserDto userDto);

	public boolean deleteUserById(String userId);

	public void deleteAllUser();

}
