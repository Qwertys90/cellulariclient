package it.dstech.services;
import java.util.List;
import it.dstech.model.User;

public interface UserService{
	
	User saveOrUpdateUser(User user);
	
	User findById(int id);
	
	List<User> findAll();
	
	void deleteUser(int id);
	
	User findByUsernameAndPassword (String username, String password);

	
}
