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

import com.outshoes.servidor.model.Marca;
import com.outshoes.servidor.service.MarcaService;

@RestController
@CrossOrigin
@RequestMapping(path="/api/marca/")
public class MarcaController {

	private final MarcaService marcaService;
	
	@Autowired
	public MarcaController (MarcaService marcaService) {
		this.marcaService = marcaService;
	}
	
	@GetMapping(path="todo")
	public List<Marca> getAllBrands () {
		return marcaService.getAllBrands();
	}
	
	 @GetMapping(path="{Id}")
	 public Optional<Marca> getBrand(@PathVariable("Id") Long id) {
		 return marcaService.getBrand(id);
	 }
		
	 @PostMapping(path="agregar")
	 public Marca addBrand (@RequestBody Marca marca) { 
		 return marcaService.addBrand(marca); 
	 }
	 
	 @DeleteMapping(path="borrar/{Id}")
	 public String deleteBrand (@PathVariable("Id") Long id) {
		 return marcaService.delBrand(id);
	 }
	 
	 @PutMapping(path="actualizar/{Id}")
	 public String updateBrand (@PathVariable("Id") Long id, @RequestBody Marca newMarca) {
		 return marcaService.updBrand(id, newMarca);
	 }
	
}
