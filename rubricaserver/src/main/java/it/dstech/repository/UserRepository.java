package it.dstech.repository;

import org.springframework.data.repository.CrudRepository;

import it.dstech.models.User;


public interface UserRepository extends CrudRepository<User, Integer>{

	User findByUsernameAndPassword (String username, String password);
	
	User findByUsername (String username);
	
}
