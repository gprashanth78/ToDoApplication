package com.pharmacy.userDto;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pharmacy.entity.Role;
import com.pharmacy.entity.User;
import com.pharmacy.repository.RoleRepository;
import com.pharmacy.repository.UserRepository;
import com.pharmacy.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void saveUser(UserDto userDto) {
		User user = new User();
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setAddress(userDto.getAddress());
		user.setContact(userDto.getContact());
		Role role = roleRepository.findByName("ROLE_ADMIN");
		if (role == null) {
			role = checkRoleExist();
		}
		user.setRoles(Arrays.asList(role));
		userRepository.save(user);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<UserDto> findAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map((user) -> convertEntityToDto(user)).collect(Collectors.toList());
	}

	private UserDto convertEntityToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		return userDto;
	}

	private Role checkRoleExist() {
		Role role = new Role();
		role.setName("ROLE_ADMIN");
		return roleRepository.save(role);
	}
}
