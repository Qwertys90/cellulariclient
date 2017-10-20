package it.dstech.services.auth;

import it.dstech.models.User;

public interface UserService {

	User saveUser(User user);

	User findByUsername(String username);
	
	User findById(int id);
	
	void deleteUser(int id);
	
	
}
