package it.dstech.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.model.Brano;
import it.dstech.repository.BranoRepository;
@Service
public class BranoServiceImpl implements BranoService{
	
	@Autowired
	BranoRepository branoRepository;
	
	@Override
	public Brano saveOrUpdateBrano(Brano brano) {
		return branoRepository.save(brano);
	}

	@Override
	public Brano findById(int id) {
		return branoRepository.findOne(id);
	}

	@Override
	public List<Brano> findAll() {
		return (List<Brano>) branoRepository.findAll();
	}

	@Override
	public void deleteBrano(int id) {
		branoRepository.delete(id);
		
	}

}