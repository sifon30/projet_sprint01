package com.saif.montres.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.saif.montres.entities.Montre;
import com.saif.montres.repos.MontreRepository;

@Service
public class MontreServiceImpl implements  MontreService{
	@Autowired
	MontreRepository  montreRepository;
	
	@Override
	public Montre saveMontre(Montre m) {
		return montreRepository.save(m);
	}

	@Override
	public Montre updateMontre(Montre m) {
		return montreRepository.save(m);
	}

	@Override
	public void deleteMontre(Montre m) {
		 montreRepository.delete(m);

	}

	@Override
	public void deleteMontreById(Long id) {
		montreRepository.deleteById(id);	
	}

	@Override
	public Montre getMontre(Long id) {
		return montreRepository.findById(id).get();
	}

	@Override
	public List<Montre> getAllMontres() {
		return montreRepository.findAll();
	}

	@Override
	public Page<Montre> getAllMontresParPage(int page, int size) {
		return montreRepository.findAll(PageRequest.of(page, size));
	}

}
