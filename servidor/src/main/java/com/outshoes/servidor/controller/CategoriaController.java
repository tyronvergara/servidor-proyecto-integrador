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

import com.outshoes.servidor.model.Categoria;
import com.outshoes.servidor.service.CategoriaService;

@RestController
@CrossOrigin
@RequestMapping(path="/api/categoria/")
public class CategoriaController {

	private final CategoriaService categoriaService;
	
	@Autowired
	public CategoriaController (CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	
	@GetMapping(path="todo")
	public List<Categoria> getAllCategories () {
		return categoriaService.getAllCategories();
	}
	
	 @GetMapping(path="{Id}")
	 public Optional<Categoria> getCategory(@PathVariable("Id") Long id) {
		 return categoriaService.getCategory(id);
	 }
		
	 @PostMapping(path="agregar")
	 public String addCategory (@RequestBody Categoria categoria) { 
		 return categoriaService.addCategory(categoria); 
	 }
	 
	 @DeleteMapping(path="borrar/{Id}")
	 public String deleteCategory (@PathVariable("Id") Long id) {
		 return categoriaService.delCategory(id);
	 }
	 
	 @PutMapping(path="actualizar/{Id}")
	 public String updateCategory (@PathVariable("Id") Long id, @RequestBody Categoria newCategoria) {
		 return categoriaService.updCategory(id, newCategoria);
	 }
	
}
