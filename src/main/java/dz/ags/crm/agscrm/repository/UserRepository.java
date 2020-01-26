package dz.ags.crm.agscrm.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import dz.ags.crm.agscrm.model.User;

@Repository
//@Service
public class UserRepository {

	private static final List<User> users;

	static {
		users = new ArrayList<>();
		users.add(new User(1L, "nom1", "prenom"));
		users.add(new User(2L, "nom2", "prenom"));
		users.add(new User(3L, "nom3", "prenom"));
	}
	
	

	public List<User> findAll() {
		return users;
	}

	public Optional<User> findById(Long id) {
		return users
		.stream()
		.filter(user -> user.getId().equals(id))
		.findFirst();
		
	}
}
