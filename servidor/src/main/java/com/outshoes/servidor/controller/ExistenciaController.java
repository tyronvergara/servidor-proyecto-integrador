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

import com.outshoes.servidor.model.Existencia;
import com.outshoes.servidor.service.ExistenciaService;

@RestController
@RequestMapping(path="/api/existencia/")
public class ExistenciaController {

	private final ExistenciaService existenciaService;
	
	@Autowired
	public ExistenciaController (ExistenciaService existenciaService) {
		this.existenciaService = existenciaService;
	}
	
	@GetMapping(path="todo")
	public List<Existencia> getAllStocks () {
		return existenciaService.getAllStocks();
	}
	
	 @GetMapping(path="{Id}")
	 public Optional<Existencia> getStock(@PathVariable("Id") Long id) {
		 return existenciaService.getStock(id);
	 }
		
	 @PostMapping(path="agregar")
	 public String addStock (@RequestBody Existencia existencia) { 
		 return existenciaService.addStock(existencia); 
	 }
	 
	 @DeleteMapping(path="{Id}")
	 public String deleteStock (@PathVariable("Id") Long id) {
		 return existenciaService.delStock(id);
	 }
	 
	 @PutMapping(path="{Id}")
	 public String updateStock (@PathVariable("Id") Long id, @RequestBody Existencia newExistencia) {
		 return existenciaService.updStock(id, newExistencia);
	 }
	
}
