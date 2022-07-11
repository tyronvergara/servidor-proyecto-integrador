package com.outshoes.servidor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inventario {

	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	private Long Producto_id;
	private Long Talla_id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProducto_id() {
		return Producto_id;
	}
	public void setProducto_id(Long producto_id) {
		Producto_id = producto_id;
	}
	public Long getTalla_id() {
		return Talla_id;
	}
	public void setTalla_id(Long talla_id) {
		Talla_id = talla_id;
	}
	
}
