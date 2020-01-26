package dz.ags.crm.agscrm.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import dz.ags.crm.agscrm.model.User;
import dz.ags.crm.agscrm.repository.UserRepository;
import dz.ags.crm.agscrm.service.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;
	private UserService userService;

	private List<User> users;
	private User user;

	@Before
	public void setUp() {
		userService = new UserServiceImpl(userRepository);

		user = new User(90000L, "Test", "Test");
		users = new ArrayList<>();
		users.add(user);
	}

	@Test
	public void findAll() {
		BDDMockito.given(userRepository.findAll()).willReturn(users);

		List<User> resultat = userService.findAll();

		assertNotNull(resultat);
		assertEquals(1, resultat.size());
		assertEquals(user, resultat.get(0));

		BDDMockito.verify(userRepository, BDDMockito.times(1)).findAll();
		BDDMockito.verifyNoMoreInteractions(userRepository);
	}

	@Test
	public void findById() {
		BDDMockito.given(userRepository.findById(ArgumentMatchers.anyLong())).willReturn(Optional.of(user));
		// BDDMockito.given(userRepository.findById(1L)).willReturn(Optional.of(user));

		for (Long id : new Long[] { 0L, 1L, 2L }) {
			Optional<User> optionalUser = userService.findById(id);
			assertTrue(optionalUser.isPresent());
			assertEquals(user, optionalUser.get());
		}

		BDDMockito.verify(userRepository, BDDMockito.times(3)).findById(ArgumentMatchers.anyLong());
		BDDMockito.verifyNoMoreInteractions(userRepository);
	}

	@Test
	public void findById__empty() {

		BDDMockito.given(userRepository.findById(null)).willReturn(Optional.empty());

		Optional<User> optionalUser = userService.findById(null);
		assertFalse(optionalUser.isPresent());

		// BDDMockito.verify(userRepository, BDDMockito.times(1)).findById(null);
		BDDMockito.verify(userRepository, BDDMockito.times(1)).findById(ArgumentMatchers.any());
		BDDMockito.verifyNoMoreInteractions(userRepository);
	}
}
