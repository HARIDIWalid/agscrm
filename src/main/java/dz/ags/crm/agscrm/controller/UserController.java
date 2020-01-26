package dz.ags.crm.agscrm.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dz.ags.crm.agscrm.model.User;
import dz.ags.crm.agscrm.model.dto.UserDTO;
import dz.ags.crm.agscrm.service.UserService;

@RestController
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/users",produces = "application/json")
	public @ResponseBody List<UserDTO> findAll() {
		return userService.findAll()
				.stream()
				.map(UserDTO::new)
				//.map(user -> new UserDTO(user))
				.collect(Collectors.toList())
				;
	}
	
	@GetMapping(path = "/users/{id}", produces = "application/json")
	public @ResponseBody Optional<User> findById(@PathVariable Long id) {
		return userService.findById(id);
	}
}
