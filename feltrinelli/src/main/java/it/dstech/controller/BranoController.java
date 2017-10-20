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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.model.Brano;
import it.dstech.services.BranoService;
@RestController
@RequestMapping("/brano")
public class BranoController {
	
	@Autowired
	private BranoService branoService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/saveupdate")
	public ResponseEntity<Brano> saveOrUpdateBrano(@RequestBody Brano brano) {
		try {
			Brano saved = branoService.saveOrUpdateBrano(brano);
			logger.info(saved + " saved");
			return new ResponseEntity<Brano>(saved, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Errore " + e);
			return new ResponseEntity<Brano>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Brano> findById(@PathVariable int id) {
		try {
			Brano find = branoService.findById(id);
			logger.info(find + " founded");
			if(find!=null)
			return new ResponseEntity<Brano>(find, HttpStatus.OK);
			else
			return new ResponseEntity<Brano>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.error("Errore  " + e);
			return new ResponseEntity<Brano>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Brano>> findAll() {
		try {
			List<Brano> find = branoService.findAll();
			logger.info(find + " founded");
			if(find!=null)
			return new ResponseEntity<List<Brano>>(find, HttpStatus.OK);
			else
			return new ResponseEntity<List<Brano>>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.error("Errore " + e);
			return new ResponseEntity<List<Brano>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping("/delete/{id}")
	public ResponseEntity<Brano> deletePersona(@PathVariable("id") int id) {
		try {
			branoService.deleteBrano(id);
			logger.info(id + " deleted");
			return new ResponseEntity<Brano>(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Errore " + e);
			return new ResponseEntity<Brano>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
