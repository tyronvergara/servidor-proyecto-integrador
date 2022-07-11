package com.outshoes.servidor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto {
	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	private String sku;
	private String nombre;
	private String descripcion;
	private String imagen;
	@Column(name="precio", columnDefinition="Decimal(6,2)")
	private double precio;
	private int Categoria_id;
	private int Coleccion_id;
	private int Marca_id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCategoria_id() {
		return Categoria_id;
	}
	public void setCategoria_id(int categoria_id) {
		Categoria_id = categoria_id;
	}
	public int getColeccion_id() {
		return Coleccion_id;
	}
	public void setColeccion_id(int coleccion_id) {
		Coleccion_id = coleccion_id;
	}
	public int getMarca_id() {
		return Marca_id;
	}
	public void setMarca_id(int marca_id) {
		Marca_id = marca_id;
	}
	
	
}
