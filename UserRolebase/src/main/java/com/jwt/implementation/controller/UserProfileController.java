package com.jwt.implementation.controller;

import java.util.HashMap;
import java.util.Map;



import com.jwt.implementation.service.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.jwt.implementation.config.JwtGeneratorValidator;
import com.jwt.implementation.model.User;
import com.jwt.implementation.model.UserDTO;
import com.jwt.implementation.repository.UserRepository;
import com.jwt.implementation.service.DefaultUserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/user/api")
public class UserProfileController {
	private static final Logger LOGGER = LogManager.getLogger(UserProfileController.class);
	@Autowired
	private UserServiceImpl daoService;

	@Autowired
	UserRepository userRepo;

	@Autowired
	AuthenticationManager authManager;

	@Autowired
	JwtGeneratorValidator jwtGenVal;

	
	@Autowired
	DefaultUserService userService;
	@PostMapping("/registration")
	public ResponseEntity<Object> registerUser(@Valid @RequestBody UserDTO userDto) {
		if (daoService.emailExists(userDto.getEmail())) {
			return generateRespose("Email already in use", HttpStatus.BAD_REQUEST, userDto);
		}

		User users = userService.save(userDto);

		if (users == null) {
			return generateRespose("Not able to save user", HttpStatus.BAD_REQUEST, userDto);
		} else {
			return generateRespose("User saved successfully: " + users.getId(), HttpStatus.OK, users);
		}
	}


	@GetMapping("/genToken")
	public String generateJwtToken(@RequestBody UserDTO userDto) throws Exception {
		
			Authentication authentication = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(userDto.getUserName(), userDto.getPassword()));
			//hold logged user information SecurityContextHolder
			SecurityContextHolder.getContext().setAuthentication(authentication);
		LOGGER.info("genToken API is called.");
		
		return jwtGenVal.generateToken(authentication);
	}

	public ResponseEntity<Object> generateRespose(String message, HttpStatus st, Object responseobj) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("meaasge", message);
		map.put("Status", st.value());
		map.put("data", responseobj);

		return new ResponseEntity<Object>(map, st);
	}
	@GetMapping("/profile")
	public ResponseEntity<User> readUser() {

		return new ResponseEntity<User>(daoService.readUser(), HttpStatus.OK);
	}

	@PutMapping("/updateprofile")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return new ResponseEntity<User>(daoService.updateUser(user), HttpStatus.OK);
	}

	@DeleteMapping("/deactivate")
	public ResponseEntity<HttpStatus> deleteUser() {
		daoService.deleteUser();
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}


}
