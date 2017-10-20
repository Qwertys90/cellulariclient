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
import it.dstech.model.Album;
import it.dstech.services.AlbumService;

@RestController
@RequestMapping("/album")
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/saveupdate")
	public ResponseEntity<Album> saveOrUpdateAlbum(@RequestBody Album album) {
		try {
			Album saved = albumService.saveOrUpdateAlbum(album);
			logger.info(saved + " saved");
			return new ResponseEntity<Album>(saved, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Errore " + e);
			return new ResponseEntity<Album>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Album> findById(@PathVariable int id) {
		try {
			Album find = albumService.findById(id);
			logger.info(find + " founded");
			if(find!=null)
			return new ResponseEntity<Album>(find, HttpStatus.OK);
			else
			return new ResponseEntity<Album>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.error("Errore  " + e);
			return new ResponseEntity<Album>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Album>> findAll() {
		try {
			List<Album> find = albumService.findAll();
			logger.info(find + " founded");
			if(find!=null)
			return new ResponseEntity<List<Album>>(find, HttpStatus.OK);
			else
			return new ResponseEntity<List<Album>>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.error("Errore " + e);
			return new ResponseEntity<List<Album>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping("/delete/{id}")
	public ResponseEntity<Album> deletePersona(@PathVariable("id") int id) {
		try {
			albumService.deleteAlbum(id);
			logger.info(id + " deleted");
			return new ResponseEntity<Album>(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Errore " + e);
			return new ResponseEntity<Album>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
