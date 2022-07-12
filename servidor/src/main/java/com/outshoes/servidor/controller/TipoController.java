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

import com.outshoes.servidor.model.Tipo;
import com.outshoes.servidor.service.TipoService;

@RestController
@CrossOrigin
@RequestMapping(path="/api/tipo/")
public class TipoController {

	private final TipoService tipoService;
	
	@Autowired
	public TipoController (TipoService tipoService) {
		this.tipoService = tipoService;
	}
	
	@GetMapping(path="todo")
	public List<Tipo> getAllTypes () {
		return tipoService.getAllTypes();
	}
	
	 @GetMapping(path="{Id}")
	 public Optional<Tipo> getType(@PathVariable("Id") Long id) {
		 return tipoService.getType(id);
	 }
		
	 @PostMapping(path="agregar")
	 public String addType (@RequestBody Tipo tipo) { 
		 return tipoService.addType(tipo); 
	 }
	 
	 @DeleteMapping(path="{Id}")
	 public String deleteType (@PathVariable("Id") Long id) {
		 return tipoService.delType(id);
	 }
	 
	 @PutMapping(path="{Id}")
	 public String updateType (@PathVariable("Id") Long id, @RequestBody Tipo newTipo) {
		 return tipoService.updType(id, newTipo);
	 }
	
}
