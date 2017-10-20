package it.dstech.services;

import java.util.List;

import javax.persistence.Query;

import it.dstech.models.User;

public interface UserService {

	User saveUser(User user);

	User getUserById(int id);

	User deleteUser(int id);
	
	User getUserByUsernameAndPassword(String username, String password);
}
