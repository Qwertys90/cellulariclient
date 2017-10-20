package it.dstech.services;

import java.util.List;

import it.dstech.model.Brano;

public interface BranoService {
	
	Brano saveOrUpdateBrano(Brano brano);
	
	Brano findById(int id);
	
	List<Brano> findAll();
	
	void deleteBrano(int id);
	
}
