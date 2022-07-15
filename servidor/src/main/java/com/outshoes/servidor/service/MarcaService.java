package com.outshoes.servidor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outshoes.servidor.model.Marca;
import com.outshoes.servidor.repository.MarcaRepository;

@Service

public class MarcaService {
	
	private final MarcaRepository marcaRepository;
	
	@Autowired
	public MarcaService (MarcaRepository marcaRepository) {
		this.marcaRepository = marcaRepository;
	}
	
	public List<Marca> getAllBrands () {
		return marcaRepository.findAll();
	}
	
	public Marca addBrand (Marca marca) { 
		
		Marca n = new Marca();
		
		n.setNombre(marca.getNombre());
	  
		marcaRepository.save(n); 
		return n; 
	 }

	public Optional <Marca> getBrand(Long id) {
		return marcaRepository.findById(id);
	}

	public String delBrand(Long id) {
		marcaRepository.deleteById(id);
		return "Marca borrada";
	}

	public String updBrand(Long id, Marca newMarca) {
	    marcaRepository.findById(id)
	    	      .map(marca -> {
	    	    	  marca.setNombre(newMarca.getNombre());
	    	    	  return marcaRepository.save(marca);
	    	      })
	    	      .orElseGet(() -> {
	    	        return marcaRepository.save(newMarca);
	    	      });
	    
	    return "Marca actualizada o creada";
	}
	
}
