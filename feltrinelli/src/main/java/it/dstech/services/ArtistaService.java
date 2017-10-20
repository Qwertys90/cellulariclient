package it.dstech.services;

import java.util.List;

import it.dstech.model.Artista;

public interface ArtistaService {
	
	Artista saveOrUpdateArtista(Artista artista);
	
	Artista findById(int id);
	
	List<Artista> findAll();
	
	void deleteArtista(int id);
	
}
