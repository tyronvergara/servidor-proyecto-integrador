package com.outshoes.servidor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outshoes.servidor.model.Tipo;
import com.outshoes.servidor.repository.TipoRepository;

@Service

public class TipoService {

	private final TipoRepository tipoRepository;
	
	@Autowired
	public TipoService (TipoRepository tipoRepository) {
		this.tipoRepository = tipoRepository;
	}
	
	public List<Tipo> getAllTypes () {
		return tipoRepository.findAll();
	}
	
	public String addType (Tipo tipo) { 
		
		Tipo n = new Tipo();
		
		n.setNombre(tipo.getNombre());
	  
		tipoRepository.save(n); 
		return "Tipo agregado"; 
	 }

	public Optional <Tipo> getType(Long id) {
		return tipoRepository.findById(id);
	}

	public String delType(Long id) {
		tipoRepository.deleteById(id);
		return "Tipo borrado";
	}

	public String updType(Long id, Tipo newTipo) {
	    tipoRepository.findById(id)
	    	      .map(tipo -> {
	    	    	  tipo.setNombre(newTipo.getNombre());
	    	    	  return tipoRepository.save(tipo);
	    	      })
	    	      .orElseGet(() -> {
	    	        return tipoRepository.save(newTipo);
	    	      });
	    
	    return "Tipo actualizado o creado";
	}
	
}
