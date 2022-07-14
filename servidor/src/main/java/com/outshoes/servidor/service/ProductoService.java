package com.outshoes.servidor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.outshoes.servidor.model.Producto;
import com.outshoes.servidor.repository.ProductoRepository;

@Service

public class ProductoService {

	private ProductoRepository productoRepository;
	
	@Autowired
	public ProductoService (ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	
	public List<Producto> getProductsDesc () {
		return productoRepository.findAllByOrderByIdDesc();
	}
	
	public List<Producto> getAllProducts () {
		return productoRepository.findAll();
	}

	public Optional<Producto> getProduct(Long id) {
		return productoRepository.findById(id);
	}

	public Producto addProduct(Producto producto) {
		productoRepository.save(producto);
		return producto;
	}

	public Optional<Producto> delProduct(Long id) {
		Optional<Producto> producto = productoRepository.findById(id);
		productoRepository.deleteById(id);
		return producto;
	}

	public String updProduct(Long id, Producto newProducto) {
	    productoRepository.findById(id)
	      .map(producto -> {
	    	  producto.setSku(newProducto.getSku());
	    	  producto.setNombre(newProducto.getNombre());
	    	  producto.setDescripcion(newProducto.getDescripcion());
	    	  producto.setImagen(newProducto.getImagen());
	    	  producto.setPrecio(newProducto.getPrecio());
	    	  producto.setCategoria(newProducto.getCategoria());
	    	  producto.setColeccion(newProducto.getColeccion());
	    	  producto.setMarca(newProducto.getMarca());
	    	  //producto.setMarca_id(newProducto.getMarca_id());
	    	  return productoRepository.save(producto);
	      })
	      .orElseGet(() -> {
	        return productoRepository.save(newProducto);
	      });

	    return "Usuario actualizado o creado";
	}
	
	public List<Producto> getProductsPagination(int pag, int tam) {
		Pageable n = PageRequest.of(pag, tam);
		Page<Producto> pagina = productoRepository.findAll(n);
		return pagina.getContent();
	}

	public Long getProductoCount() {
		return productoRepository.count();
	}
}
