package it.dstech.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import it.dstech.model.User;
import it.dstech.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/saveupdate")
	public ResponseEntity<User> saveOrUpdateUser(@RequestBody User user) {
		try {
			User saved = userService.saveOrUpdateUser(user);
			logger.info(saved + " saved");
			return new ResponseEntity<User>(saved, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Errore " + e);
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<User> findById(@PathVariable int id) {
		try {
			User find = userService.findById(id);
			logger.info(find + " founded");
			if(find!=null)
			return new ResponseEntity<User>(find, HttpStatus.OK);
			else
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.error("Errore  " + e);
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<User>> findAll() {
		try {
			List<User> find = userService.findAll();
			logger.info(find + " founded");
			if(find!=null)
			return new ResponseEntity<List<User>>(find, HttpStatus.OK);
			else
			return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.error("Errore " + e);
			return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping("/delete/{id}")
	public ResponseEntity<User> deletePersona(@PathVariable("id") int id) {
		try {
			userService.deleteUser(id);
			logger.info(id + " deleted");
			return new ResponseEntity<User>(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Errore " + e);
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findbypasswordandusername")
	public ResponseEntity<User> getUserByUsernameAndPassword(@RequestHeader String username, @RequestHeader String password) {
		try {
			User find = userService.findByUsernameAndPassword(username, password);
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
