package dz.ags.crm.agscrm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.ags.crm.agscrm.model.User;
import dz.ags.crm.agscrm.repository.UserRepository;
import dz.ags.crm.agscrm.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) { 
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		//userRepository.findById(id);
		return userRepository.findById(id);
	}

}
