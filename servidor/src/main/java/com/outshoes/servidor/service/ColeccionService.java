package com.outshoes.servidor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outshoes.servidor.model.Coleccion;
import com.outshoes.servidor.repository.ColeccionRepository;

@Service

public class ColeccionService {

	private final ColeccionRepository coleccionRepository;
	
	@Autowired
	public ColeccionService (ColeccionRepository coleccionRepository) {
		this.coleccionRepository = coleccionRepository;
	}
	
	public List<Coleccion> getAllCollections () {
		return coleccionRepository.findAll();
	}
	
	public String addCollection (Coleccion coleccion) { 
		
		Coleccion n = new Coleccion();
		
		n.setNombre(coleccion.getNombre());
	  
		coleccionRepository.save(n); 
		return "Coleccion agregada"; 
	 }

	public Optional <Coleccion> getCollection(Long id) {
		return coleccionRepository.findById(id);
	}

	public String delCollection(Long id) {
		coleccionRepository.deleteById(id);
		return "Coleccion borrada";
	}

	public String updCollection(Long id, Coleccion newColeccion) {
	    coleccionRepository.findById(id)
	    	      .map(coleccion -> {
	    	    	  coleccion.setNombre(newColeccion.getNombre());
	    	    	  return coleccionRepository.save(coleccion);
	    	      })
	    	      .orElseGet(() -> {
	    	        return coleccionRepository.save(newColeccion);
	    	      });
	    
	    return "Coleccion actualizada o creada";
	}
	
}
