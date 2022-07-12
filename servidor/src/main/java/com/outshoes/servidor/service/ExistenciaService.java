package com.outshoes.servidor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outshoes.servidor.model.Existencia;
import com.outshoes.servidor.repository.ExistenciaRepository;

@Service

public class ExistenciaService {

	private final ExistenciaRepository existenciaRepository;
	
	@Autowired
	public ExistenciaService (ExistenciaRepository existenciaRepository) {
		this.existenciaRepository = existenciaRepository;
	}
	
	public List<Existencia> getAllStocks () {
		return existenciaRepository.findAll();
	}
	
	
	public String addStock (Existencia existencia) { 
		
		Existencia n = new Existencia();
		
		//n.setInventario_id(existencia.getInventario_id());
		n.setInventario(existencia.getInventario());
		n.setCantidad(existencia.getCantidad());
	  
		existenciaRepository.save(n); 
		return "Existencia agregada"; 
	 }

	public Optional <Existencia> getStock(Long id) {
		return existenciaRepository.findById(id);
	}

	public String delStock(Long id) {
		existenciaRepository.deleteById(id);
		return "Existencia borrada";
	}

	public String updStock(Long id, Existencia newExistencia) {
	    existenciaRepository.findById(id)
	    	      .map(existencia -> {
	    	    	  //existencia.setInventario_id(newExistencia.getInventario_id());
	    	    	  existencia.setInventario(newExistencia.getInventario());
	    	    	  existencia.setCantidad(newExistencia.getCantidad());
	    	    	  return existenciaRepository.save(existencia);
	    	      })
	    	      .orElseGet(() -> {
	    	        return existenciaRepository.save(newExistencia);
	    	      });
	    
	    return "Existencia actualizada o creada";
	}
	
}
