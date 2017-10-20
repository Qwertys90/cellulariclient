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

import it.dstech.model.Artista;
import it.dstech.services.ArtistaService;

@RestController
@RequestMapping("/artista")
public class ArtistaController {
	
	@Autowired
	private ArtistaService artistaService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@PostMapping("/saveupdate")
	public ResponseEntity<Artista> saveOrUpdateArtista(@RequestBody Artista artista) {
		try {
			Artista saved = artistaService.saveOrUpdateArtista(artista);
			logger.info(saved + " saved");
			return new ResponseEntity<Artista>(saved, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Errore " + e);
			return new ResponseEntity<Artista>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Artista> findById(@PathVariable int id) {
		try {
			Artista find = artistaService.findById(id);
			logger.info(find + " founded");
			if(find!=null)
			return new ResponseEntity<Artista>(find, HttpStatus.OK);
			else
			return new ResponseEntity<Artista>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.error("Errore  " + e);
			return new ResponseEntity<Artista>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Artista>> findAll() {
		try {
			List<Artista> find = artistaService.findAll();
			logger.info(find + " founded");
			if(find!=null)
			return new ResponseEntity<List<Artista>>(find, HttpStatus.OK);
			else
			return new ResponseEntity<List<Artista>>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.error("Errore " + e);
			return new ResponseEntity<List<Artista>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping("/delete/{id}")
	public ResponseEntity<Artista> deletePersona(@PathVariable("id") int id) {
		try {
			artistaService.deleteArtista(id);
			logger.info(id + " deleted");
			return new ResponseEntity<Artista>(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Errore " + e);
			return new ResponseEntity<Artista>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
