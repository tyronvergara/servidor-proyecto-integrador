package com.outshoes.servidor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Existencia {

	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	private Long cantidad;
	
    @ManyToOne(optional = false)
    @JoinColumn(name = "Inventario_id", nullable = false,
        referencedColumnName = "id")
    private Inventario inventario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * public Long getInventario_id() { return Inventario_id; } public void
	 * setInventario_id(Long inventario_id) { Inventario_id = inventario_id; }
	 */
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public Inventario getInventario() {
		return inventario;
	}
	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}
	
}
