package it.dstech.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.model.Artista;
import it.dstech.repository.ArtistaRepository;
@Service
public class ArtistaServiceImpl implements ArtistaService{
	
	@Autowired
	ArtistaRepository artistaRepository;


	@Override
	public Artista saveOrUpdateArtista(Artista artista) {
		return artistaRepository.save(artista);
	}

	@Override
	public Artista findById(int id) {
		return artistaRepository.findOne(id);
	}

	@Override
	public List<Artista> findAll() {
		return (List<Artista>) artistaRepository.findAll();
	}

	@Override
	public void deleteArtista(int id) {
		artistaRepository.delete(id);
		
	}

}
