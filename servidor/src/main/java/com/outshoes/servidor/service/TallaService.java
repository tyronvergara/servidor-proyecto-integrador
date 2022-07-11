package com.outshoes.servidor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outshoes.servidor.model.Talla;
import com.outshoes.servidor.repository.TallaRepository;

@Service

public class TallaService {

	private final TallaRepository tallaRepository;
	
	@Autowired
	public TallaService (TallaRepository tallaRepository) {
		this.tallaRepository = tallaRepository;
	}
	
	public List<Talla> getAllSizes () {
		return tallaRepository.findAll();
	}
	
	public String addSize (Talla talla) { 
		
		Talla n = new Talla();
		
		n.setNumero(talla.getNumero());
	  
		tallaRepository.save(n); 
		return "Talla agregada"; 
	 }

	public Optional <Talla> getSize(Long id) {
		return tallaRepository.findById(id);
	}

	public String delSize(Long id) {
		tallaRepository.deleteById(id);
		return "Talla borrada";
	}

	public String updSize(Long id, Talla newTalla) {
	    tallaRepository.findById(id)
	    	      .map(talla -> {
	    	    	  talla.setNumero(newTalla.getNumero());
	    	    	  return tallaRepository.save(talla);
	    	      })
	    	      .orElseGet(() -> {
	    	        return tallaRepository.save(newTalla);
	    	      });
	    
	    return "Talla actualizada o creada";
	}
	
}
