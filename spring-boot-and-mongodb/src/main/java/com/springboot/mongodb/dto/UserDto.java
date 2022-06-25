package com.springboot.mongodb.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

/* 
 *Implemented by shailendra
*/

@Data
public class UserDto {
	
	private String id;

	@NotBlank(message =  "First name cannot be blank")
	private String firstName;

	@NotBlank(message =  "Last name cannot be blank")
	private String lastName;

	@NotBlank(message = "Email cannot be blank")
	@Email(message = "Email should be valid")
	private String email;

	@NotBlank(message =  "Mobile cannot be blank")
	private String mobile;
	
}
