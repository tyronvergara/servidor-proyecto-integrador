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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.outshoes.servidor.model.Producto;
import com.outshoes.servidor.service.ProductoService;

@RestController
@CrossOrigin
@RequestMapping(path="/api/producto/")
public class ProductoController {

	private ProductoService productoService;
	
	@Autowired
	public ProductoController (ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@GetMapping(path="todo")
	public List<Producto> getProducts () {
		return productoService.getAllProducts();
	}
	
	@GetMapping(path="{Id}")
	public Optional<Producto> getProduct (@PathVariable("Id") Long id) {
		return productoService.getProduct(id);
	}
	
	@PostMapping(path="agregar")
	public String addProduct (@RequestBody Producto producto) {
		return productoService.addProduct(producto);
	}
	
	@DeleteMapping(path="{Id}")
	public String deleteProduct (@PathVariable("Id") Long id) {
		return productoService.delProduct(id);
	}
	
	@PutMapping(path="{Id}")
	public String updateProduct (@PathVariable("Id") Long id, @RequestBody Producto newProducto) {
		return productoService.updProduct(id, newProducto);
	}
	
	@GetMapping(path="pagina")
	public List<Producto> getProductsPagination (@RequestParam("pag") int pagina, @RequestParam("tam") int tamano) {
		return productoService.getProductsPagination(pagina, tamano);
	}
}
