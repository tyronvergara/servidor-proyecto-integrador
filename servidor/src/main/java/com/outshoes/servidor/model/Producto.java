package com.outshoes.servidor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
    @ManyToOne(optional = false)
    @JoinColumn(name = "Categoria_id", nullable = false,
        referencedColumnName = "id")
    private Categoria categoria;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "Coleccion_id", nullable = false,
        referencedColumnName = "id")
    private Coleccion coleccion;
	
    @ManyToOne(optional = false)
    @JoinColumn(name = "Marca_id", nullable = false,
        referencedColumnName = "id")
    private Marca marca;
	
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
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Coleccion getColeccion() {
		return coleccion;
	}
	public void setColeccion(Coleccion coleccion) {
		this.coleccion = coleccion;
	}
	
}
