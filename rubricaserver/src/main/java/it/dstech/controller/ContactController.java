package it.dstech.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.models.Contact;
import it.dstech.repository.ContactRepository;
import it.dstech.repository.UserRepository;


	@RestController
	@RequestMapping("/contact")
	public class ContactController {

		private static final Logger logger = Logger.getLogger(ContactController.class.getName());

		@Autowired
		private ContactRepository contactRepo;
		@Autowired
		private UserRepository userRepo;
		
		@PostMapping("/save/{id}")
		public ResponseEntity<Contact> saveOrUpdateContact(@RequestBody Contact contact, @PathVariable("id") int id) {
			try {
				contact.setUser(userRepo.findOne(id));
				Contact saved = contactRepo.save(contact);
				logger.info(saved + " saved");
				return new ResponseEntity<Contact>(saved, HttpStatus.CREATED);
			} catch (Exception e) {
				logger.info("Errore " + e);
				return new ResponseEntity<Contact>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@GetMapping("/findByUser/{userId}")
		public ArrayList<Contact> getListContactsByUserId(@PathVariable("userId") int userId) {
			logger.info("List contacts completed.");
			return (ArrayList<Contact>) contactRepo.findByUser_Id(userId);
		}
		
		@GetMapping("/getbyid/{id}")
		public ResponseEntity<Contact> findById(@PathVariable int id) {
			try {
				Contact find = contactRepo.findOne(id);
				logger.info(find + " founded");
				if(find!=null)
				return new ResponseEntity<Contact>(find, HttpStatus.OK);
				else
				return new ResponseEntity<Contact>(HttpStatus.INTERNAL_SERVER_ERROR);
			} catch (Exception e) {
				logger.info("Errore  " + e);
				return new ResponseEntity<Contact>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		@RequestMapping("/delete/{id}")
		public ResponseEntity<Contact> deletePersona(@PathVariable("id") int id) {
			try {
				contactRepo.delete(id);
				logger.info(id + " deleted");
				return new ResponseEntity<Contact>(HttpStatus.OK);
			} catch (Exception e) {
				logger.info("Errore " + e);
				return new ResponseEntity<Contact>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
	}

