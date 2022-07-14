package com.outshoes.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outshoes.servidor.model.Coleccion;
import com.outshoes.servidor.service.ColeccionService;

@RestController
@CrossOrigin
@RequestMapping(path="/api/coleccion/")
public class ColeccionController {

	private final ColeccionService coleccionService;
	
	@Autowired
	public ColeccionController (ColeccionService coleccionService) {
		this.coleccionService = coleccionService;
	}
	
	@GetMapping(path="todo")
	public List<Coleccion> getAllCollections () {
		return coleccionService.getAllCollections();
	}
	
	 @GetMapping(path="{Id}")
	 public Optional<Coleccion> getCollection(@PathVariable("Id") Long id) {
		 return coleccionService.getCollection(id);
	 }
		
	 @PostMapping(path="agregar")
	 public String addCollection (@RequestBody Coleccion coleccion) { 
		 return coleccionService.addCollection(coleccion); 
	 }
	 
	 @DeleteMapping(path="borrar/{Id}")
	 public String deleteCollection (@PathVariable("Id") Long id) {
		 return coleccionService.delCollection(id);
	 }
	 
	 @PutMapping(path="actualizar/{Id}")
	 public String updateCollection (@PathVariable("Id") Long id, @RequestBody Coleccion newColeccion) {
		 return coleccionService.updCollection(id, newColeccion);
	 }
	
}
