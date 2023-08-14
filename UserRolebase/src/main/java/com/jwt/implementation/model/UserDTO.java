package com.jwt.implementation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotBlank(message="please Enter Name")
	private String userName;
    @NotNull(message = "Please Enter password")
    @Size(min=3,message="password should be at list 3 characters")
    private String password;
    @Email(message="Enter valid email")
    private String email;
    @NotNull(message = "Please Enter role")
    private String role;
}

