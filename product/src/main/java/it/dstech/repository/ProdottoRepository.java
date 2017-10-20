package it.dstech.repository;

import org.springframework.data.repository.CrudRepository;

import it.dstech.model.Prodotto;


public interface ProdottoRepository extends CrudRepository<Prodotto, Integer>{
	
	Prodotto findByCodice (int codice);

}
