package com.outshoes.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outshoes.servidor.model.Talla;
import com.outshoes.servidor.service.TallaService;

@RestController
@RequestMapping(path="/api/talla/")
public class TallaController {

	private final TallaService tallaService;
	
	@Autowired
	public TallaController (TallaService tallaService) {
		this.tallaService = tallaService;
	}
	
	@GetMapping(path="todo")
	public List<Talla> getAllSizes () {
		return tallaService.getAllSizes();
	}
	
	 @GetMapping(path="{Id}")
	 public Optional<Talla> getSize(@PathVariable("Id") Long id) {
		 return tallaService.getSize(id);
	 }
		
	 @PostMapping(path="agregar")
	 public String addSize (@RequestBody Talla talla) { 
		 return tallaService.addSize(talla); 
	 }
	 
	 @DeleteMapping(path="{Id}")
	 public String deleteSize (@PathVariable("Id") Long id) {
		 return tallaService.delSize(id);
	 }
	 
	 @PutMapping(path="{Id}")
	 public String updateSize (@PathVariable("Id") Long id, @RequestBody Talla newTalla) {
		 return tallaService.updSize(id, newTalla);
	 }
	
}
