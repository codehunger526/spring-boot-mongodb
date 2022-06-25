package com.springboot.mongodb.service.impl;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mongodb.dto.UserDto;
import com.springboot.mongodb.entity.UserEntity;
import com.springboot.mongodb.repository.UserRepository;
import com.springboot.mongodb.service.UserService;

/* 
 *Implemented by shailendra
*/

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	public UserEntity createUser(UserDto userDto) {
		return userRepository.save(modelMapper.map(userDto, UserEntity.class));
	}

	@Override
	public List<UserDto> getAllUser() {
		List<UserEntity> userList = userRepository.findAll();

		Type userDto = new TypeToken<List<UserDto>>() {
		}.getType();
		List<UserDto> userDtoList = modelMapper.map(userList, userDto);

		return userDtoList;
	}

	@Override
	public UserDto getUserById(String userId) {
		Optional<UserEntity> userOptional = userRepository.findById(userId);
		if (userOptional.isPresent()) {
			return modelMapper.map(userOptional.get(), UserDto.class);
		}
		return null;
	}

	@Override
	public UserEntity updateUserById(String userId, UserDto userDto) {
		Optional<UserEntity> userOptional = userRepository.findById(userId);
		if (userOptional.isPresent()) {
			UserEntity userEntity = userOptional.get();
			modelMapper.map(userDto, userEntity);
			return userRepository.save(userEntity);
		}
		return null;
	}

	@Override
	public boolean deleteUserById(String userId) {
		Optional<UserEntity> userOptional = userRepository.findById(userId);
		if (userOptional.isPresent()) {
			userRepository.deleteById(userId);
			return true;
		}
		return false;
	}

	@Override
	public void deleteAllUser() {
		userRepository.deleteAll();
	}

}
