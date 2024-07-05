package com.todoApp.userDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private String password;
}
