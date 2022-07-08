package org.outshoes.outshoesserver.services;

import java.util.ArrayList;

import org.outshoes.outshoesserver.Producto;
import org.springframework.stereotype.Service;

@Service
public class ProductoServices {
	public final ArrayList<Producto> lista = new ArrayList<Producto>();
	
	public ProductoServices () {
		lista.add(new Producto(1, "ADD1234", "Tenis Adidas", "Unos tenis adidas", 1, 1, 1, 5, 2, 7, 1299, "unaURL"));
		lista.add(new Producto(2, "NKE4321", "Tenis Nike", "Unos tenis Nike", 2, 2, 2, 5, 4, 7, 1299, "otraURL"));
	}
	
	public ArrayList<Producto> getProductos() {
		return lista;
	}
	
	public Producto getProducto(Long id) {
		Producto tmpProd = null;
		for (Producto producto : lista) {
			if (producto.getIdProducto() == id) {
				tmpProd = producto;
				break;
			}
		}
		return tmpProd;
	}

	public Producto deleteProducto(Long id) {
		Producto tmpProd = null;
		for (Producto producto : lista) {
			if (producto.getIdProducto() == id) {
				tmpProd = lista.remove(lista.indexOf(producto));
				break;
			}
		}
		return tmpProd;
	}

	public Producto addProducto(Producto producto) {
		lista.add(producto);
		return producto;
	}

	public Producto updateProducto(Long id, Producto nuevo) {
		for (Producto producto : lista) {
			if (producto.getIdProducto() == id) {
				producto.setCantidadProducto(nuevo.getCantidadProducto());
				producto.setCategoriaProducto(nuevo.getCategoriaProducto());
				producto.setColeccionProducto(nuevo.getColeccionProducto());
				producto.setColorProducto(nuevo.getColorProducto());
				producto.setDescripcionProducto(nuevo.getDescripcionProducto());
				producto.setImagenProducto(nuevo.getImagenProducto());
				producto.setMarcaProducto(nuevo.getMarcaProducto());
				producto.setNombreProducto(nuevo.getNombreProducto());
				producto.setPrecioProducto(nuevo.getPrecioProducto());
				producto.setSkuProducto(nuevo.getSkuProducto());
				producto.setTallaProducto(nuevo.getTallaProducto());
				break;
			}
		}
		return nuevo;
	}
	
	
	
}
