package org.outshoes.outshoesserver.controllers;

import java.util.List;

import org.outshoes.outshoesserver.Producto;
import org.outshoes.outshoesserver.services.ProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path="/api/productos/")
public class ProductoController {

	private final ProductoServices productoServices;
	
	@Autowired
	public ProductoController(ProductoServices productoServices) {
		this.productoServices = productoServices;
	}

	@GetMapping
	public List<Producto> getAllProducts() {
		return productoServices.getProductos();
	}
	
	@GetMapping (path="{idProducto}")
	public Producto getProduct(@PathVariable("idProducto") Long id) {
		return productoServices.getProducto(id);
	}
	
	@DeleteMapping (path="{idProducto}")
	public Producto deleteProduct(@PathVariable("idProducto") Long id) {
		return productoServices.deleteProducto(id);
	}
	
	@PostMapping
	public Producto addProducto(@RequestBody Producto producto) {
		return productoServices.addProducto(producto);
	}
	
	@PutMapping (path="{idProducto}")
	public Producto updateProducto(@PathVariable("idProducto") Long id, @RequestBody Producto nuevo) {
		return productoServices.updateProducto(id, nuevo);
	}
	
}
