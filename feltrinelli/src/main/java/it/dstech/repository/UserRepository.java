package it.dstech.repository;

import org.springframework.data.repository.CrudRepository;

import it.dstech.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	User findByUsernameAndPassword (String username, String password);
	
}
