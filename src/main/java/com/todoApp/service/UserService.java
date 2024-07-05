package com.todoApp.service;

import java.util.List;

import com.todoApp.entity.User;
import com.todoApp.userDto.UserDto;

public interface UserService {
	void saveUser(UserDto userDto);

	User findByEmail(String email);

	List<UserDto> findAllUsers();
}
