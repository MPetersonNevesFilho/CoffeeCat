package tqs.coffeeCat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tqs.coffeeCat.model.User;
import tqs.coffeeCat.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	};

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	};

	public User save(User user) {
		return userRepository.save(user);
	}

}
