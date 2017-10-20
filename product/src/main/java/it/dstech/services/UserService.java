package it.dstech.services;

import it.dstech.model.User;

public interface UserService {

	User findByUsername (String username);
	
	public User saveUser(User user);
	
}
