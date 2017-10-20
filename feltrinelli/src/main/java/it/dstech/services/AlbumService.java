package it.dstech.services;

import java.util.List;

import it.dstech.model.Album;


public interface AlbumService{
	
	Album saveOrUpdateAlbum(Album album);
	
	Album findById(int id);
	
	List<Album> findAll();
	
	void deleteAlbum(int id);
	
}
