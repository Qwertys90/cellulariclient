package it.dstech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.dstech.model.Album;
import it.dstech.repository.AlbumRepository;
@Service
public class AlbumServiceImpl implements AlbumService{
	
	@Autowired
	AlbumRepository albumRepository;
	
	@Override
	public Album saveOrUpdateAlbum(Album album) {
		return albumRepository.save(album);
	}

	@Override
	public Album findById(int id) {
		return albumRepository.findOne(id);
	}

	@Override
	public List<Album> findAll() {
		return (List<Album>) albumRepository.findAll();
	}

	@Override
	public void deleteAlbum(int id) {
		albumRepository.delete(id);
		
	}

}
