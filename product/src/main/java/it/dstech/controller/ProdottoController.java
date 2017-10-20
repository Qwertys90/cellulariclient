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
import it.dstech.model.Prodotto;
import it.dstech.services.ProdottoService;

@RestController
@RequestMapping("/prodotto")
public class ProdottoController {
	
	@Autowired
	private ProdottoService prodottoService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/getmodel")
	public ResponseEntity<Prodotto> getmodel() {
		Prodotto prodott = new Prodotto();
		return new ResponseEntity<Prodotto>(prodott, HttpStatus.CREATED);
	}

	
	@PostMapping("/saveupdate")
	public ResponseEntity<Prodotto> saveOrUpdateProdotto(@RequestBody Prodotto prodotto) {
		try {
			Prodotto saved = prodottoService.saveOrUpdateProdotto(prodotto);
			logger.info(saved + " saved");
			return new ResponseEntity<Prodotto>(saved, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Errore " + e);
			return new ResponseEntity<Prodotto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Prodotto> findById(@PathVariable int id) {
		try {
			Prodotto find = prodottoService.findById(id);
			logger.info(find + " founded");
			if(find!=null)
			return new ResponseEntity<Prodotto>(find, HttpStatus.OK);
			else
			return new ResponseEntity<Prodotto>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.error("Errore  " + e);
			return new ResponseEntity<Prodotto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findbycodice/{codice}")
	public ResponseEntity<Prodotto> getByCodice(@PathVariable int codice) {
		try {
			Prodotto find = prodottoService.findByCodice(codice);
			logger.info(find + " founded");
			if(find!=null)
			return new ResponseEntity<Prodotto>(find, HttpStatus.OK);
			else
			return new ResponseEntity<Prodotto>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.error("Errore  " + e);
			return new ResponseEntity<Prodotto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Prodotto>> findAll() {
		try {
			List<Prodotto> find = prodottoService.findAll();
			logger.info(find + " founded");
			if(find!=null)
			return new ResponseEntity<List<Prodotto>>(find, HttpStatus.OK);
			else
			return new ResponseEntity<List<Prodotto>>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.error("Errore " + e);
			return new ResponseEntity<List<Prodotto>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping("/delete/{id}")
	public ResponseEntity<Prodotto> deleteProdotto(@PathVariable("id") int id) {
		try {
			prodottoService.deleteProdotto(id);
			logger.info(id + " deleted");
			return new ResponseEntity<Prodotto>(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Errore " + e);
			return new ResponseEntity<Prodotto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
