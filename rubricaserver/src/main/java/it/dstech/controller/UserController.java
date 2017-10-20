package it.dstech.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.dstech.models.User;
import it.dstech.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class.getName());

	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/save")
	public ResponseEntity<User> saveOrUpdatePersona(@RequestBody User user) {
		try {
			User saved = userRepo.save(user);
			logger.info(saved + " saved");
			return new ResponseEntity<User>(saved, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.info("Errore " + e);
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<User> findById(@PathVariable int id) {
		try {
			User find = userRepo.findOne(id);
			logger.info(find + " founded");
			if(find!=null)
			return new ResponseEntity<User>(find, HttpStatus.OK);
			else
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.info("Errore  " + e);
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/delete/{id}")
	public ResponseEntity<User> deletePersona(@PathVariable("id") int id) {
		try {
			userRepo.delete(id);
			logger.info(id + " deleted");
			return new ResponseEntity<User>(HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Errore " + e);
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findbypasswordandusername")
	public ResponseEntity<User> getUserByUsernameAndPassword(@RequestHeader String username, @RequestHeader String password) {
		try {
			User find = userRepo.findByUsernameAndPassword(username, password);
			logger.info(find + " founded");
			if(find!=null)
				return new ResponseEntity<User>(find, HttpStatus.OK);
				else
				return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.info("Errore " + e);
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
