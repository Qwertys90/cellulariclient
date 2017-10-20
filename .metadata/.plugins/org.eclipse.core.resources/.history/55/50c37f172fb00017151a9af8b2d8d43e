package com.example.demo.controller;

import org.slf4j.LoggerFactory;

import java.util.List;

import org.slf4j.Logger;
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

import com.example.demo.models.Persona;
import com.example.demo.services.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/saveupdate")
	public ResponseEntity<Persona> saveOrUpdatePersona(@RequestBody Persona persona) {
		try {
			Persona saved = personaService.saveOrUpdatePersona(persona);
			logger.info(saved + " saved");
			return new ResponseEntity<Persona>(saved, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Errore " + e);
			return new ResponseEntity<Persona>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Persona> findById(@PathVariable int id) {
		try {
			Persona find = personaService.findById(id);
			logger.info(find + " founded");
			if(find!=null)
			return new ResponseEntity<Persona>(find, HttpStatus.OK);
			else
			return new ResponseEntity<Persona>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.error("Errore  " + e);
			return new ResponseEntity<Persona>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Persona>> findAll() {
		try {
			List<Persona> find = personaService.findAll();
			logger.info(find + " founded");
			if(find!=null)
			return new ResponseEntity<List<Persona>>(find, HttpStatus.OK);
			else
			return new ResponseEntity<List<Persona>>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.error("Errore " + e);
			return new ResponseEntity<List<Persona>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@RequestMapping("/delete/{id}")
	public ResponseEntity<Persona> deletePersona(@PathVariable("id") int id) {
		try {
			personaService.deletePersona(id);
			logger.info(id + " deleted");
			return new ResponseEntity<Persona>(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Errore " + e);
			return new ResponseEntity<Persona>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/findbyprofessione")
	public ResponseEntity<List<Persona>> findByProfessione(@RequestHeader("professione") String professione) {
		try {
			List<Persona> find = personaService.findByProfessione(professione);
			logger.info(find + " founded");
			if(find.size()>0)
				return new ResponseEntity<List<Persona>>(find, HttpStatus.OK);
				else
				return new ResponseEntity<List<Persona>>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.error("Errore " + e);
			return new ResponseEntity<List<Persona>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
