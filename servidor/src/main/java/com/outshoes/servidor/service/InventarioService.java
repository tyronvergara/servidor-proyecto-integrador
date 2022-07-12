package com.outshoes.servidor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outshoes.servidor.model.Inventario;
import com.outshoes.servidor.repository.InventarioRepository;

@Service

public class InventarioService {

	private final InventarioRepository inventarioRepository;
	
	@Autowired
	public InventarioService (InventarioRepository inventarioRepository) {
		this.inventarioRepository = inventarioRepository;
	}
	
	public List<Inventario> getAllInventories () {
		return inventarioRepository.findAll();
	}
	
	public String addInventory (Inventario inventario) { 
		
		Inventario n = new Inventario();
		
		//n.setProducto_id(inventario.getProducto_id());
		n.setProducto(inventario.getProducto());;
		//n.setTalla_id(inventario.getTalla_id());
		n.setTalla(inventario.getTalla());
		n.setCantidad(inventario.getCantidad());
	  
		inventarioRepository.save(n); 
		return "Inventario agregado"; 
	 }

	public Optional <Inventario> getInventory(Long id) {
		return inventarioRepository.findById(id);
	}

	public String delInventory(Long id) {
		inventarioRepository.deleteById(id);
		return "Inventario borrado";
	}

	public String updInventory(Long id, Inventario newInventario) {
	    inventarioRepository.findById(id)
	    	      .map(inventario -> {
	    	    	  //inventario.setProducto_id(newInventario.getProducto_id());
	    	    	  inventario.setProducto(newInventario.getProducto());
	    	    	  //inventario.setTalla_id(newInventario.getTalla_id());
	    	    	  inventario.setTalla(newInventario.getTalla());
	    	    	  inventario.setCantidad(newInventario.getCantidad());
	    	    	  return inventarioRepository.save(inventario);
	    	      })
	    	      .orElseGet(() -> {
	    	        return inventarioRepository.save(newInventario);
	    	      });
	    
	    return "Inventario actualizado o creado";
	}
	
}
