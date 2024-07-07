package com.pharmacy.service;

import java.util.List;

import com.pharmacy.entity.User;
import com.pharmacy.userDto.UserDto;

public interface UserService {
	
	void saveUser(UserDto userDto);

	User findByEmail(String email);

	List<UserDto> findAllUsers();
}
