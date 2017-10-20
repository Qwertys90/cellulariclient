package it.dstech.repository;

import org.springframework.data.repository.CrudRepository;

import it.dstech.model.Album;


public interface AlbumRepository extends CrudRepository<Album, Integer>{

}
