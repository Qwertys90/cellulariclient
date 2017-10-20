package it.dstech.services;

import java.util.List;

import it.dstech.model.Prodotto;


public interface ProdottoService {
	
	Prodotto saveOrUpdateProdotto(Prodotto prodotto);
	
	Prodotto findById(int id);
	
	Prodotto findByCodice(int id);
	
	List<Prodotto> findAll();
	
	void deleteProdotto(int id);
	
}
