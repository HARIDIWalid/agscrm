package dz.ags.crm.agscrm.service;

import java.util.List;
import java.util.Optional;

import dz.ags.crm.agscrm.model.User;

public interface UserService {

	List<User> findAll();
	Optional<User> findById(Long id);
}
