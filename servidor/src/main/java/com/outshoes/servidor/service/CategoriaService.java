package com.outshoes.servidor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outshoes.servidor.model.Categoria;
import com.outshoes.servidor.repository.CategoriaRepository;

@Service

public class CategoriaService {

	private final CategoriaRepository categoriaRepository;
	
	@Autowired
	public CategoriaService (CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	public List<Categoria> getAllCategories () {
		return categoriaRepository.findAll();
	}
	
	public String addCategory (Categoria categoria) { 
		
		Categoria n = new Categoria();
		
		n.setNombre(categoria.getNombre());
	  
		categoriaRepository.save(n); 
		return "Categoria agregada"; 
	 }

	public Optional <Categoria> getCategory(Long id) {
		return categoriaRepository.findById(id);
	}

	public String delCategory(Long id) {
		categoriaRepository.deleteById(id);
		return "Categoria borrada";
	}

	public String updCategory(Long id, Categoria newCategoria) {
	    categoriaRepository.findById(id)
	    	      .map(categoria -> {
	    	    	  categoria.setNombre(newCategoria.getNombre());
	    	    	  return categoriaRepository.save(categoria);
	    	      })
	    	      .orElseGet(() -> {
	    	        return categoriaRepository.save(newCategoria);
	    	      });
	    
	    return "Categoria actualizada o creada";
	}
	
}
