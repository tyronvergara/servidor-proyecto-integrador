package com.outshoes.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.outshoes.servidor.model.Inventario;
import com.outshoes.servidor.service.InventarioService;

@RestController
@CrossOrigin
@RequestMapping(path="/api/inventario/")
public class InventarioController {

	private final InventarioService inventarioService;
	
	@Autowired
	public InventarioController (InventarioService inventarioService) {
		this.inventarioService = inventarioService;
	}
	
	@GetMapping(path="todo")
	public List<Inventario> getAllInventories () {
		return inventarioService.getAllInventories();
	}
	
	 @GetMapping(path="{Id}")
	 public Optional<Inventario> getInventory(@PathVariable("Id") Long id) {
		 return inventarioService.getInventory(id);
	 }
		
	 @PostMapping(path="agregar")
	 public String addInventory (@RequestBody Inventario inventario) { 
		 return inventarioService.addInventory(inventario); 
	 }
	 
	 @DeleteMapping(path="{Id}")
	 public String deleteInventory (@PathVariable("Id") Long id) {
		 return inventarioService.delInventory(id);
	 }
	 
	 @PutMapping(path="{Id}")
	 public String updateInventory (@PathVariable("Id") Long id, @RequestBody Inventario newInventario) {
		 return inventarioService.updInventory(id, newInventario);
	 }
	
	 //
	 @GetMapping(path="producto")
	 public ResponseEntity<List<Inventario>> getInventoryProduct(@RequestParam("id") Long id) {
		 return inventarioService.getInventoryProduct(id);
	 }
}
