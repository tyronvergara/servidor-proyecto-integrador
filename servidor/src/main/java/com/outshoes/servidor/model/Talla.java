package com.outshoes.servidor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class Talla {

	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	private String numero;
	
	/*
	 * @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 * 
	 * @JoinTable(name = "Inventario", joinColumns = @JoinColumn(name = "id",
	 * referencedColumnName = "Talla_id"), inverseJoinColumns = @JoinColumn(name =
	 * "id", referencedColumnName = "Producto_id"))
	 */
	/*
	 * @JoinTable( name = "Inventario", joinColumns = @JoinColumn(name =
	 * "Producto_id", nullable = false), inverseJoinColumns
	 * = @JoinColumn(name="Talla_id", nullable = false) )
	 * 
	 * @ManyToMany(cascade = CascadeType.ALL) private List<Existencia> existencia;
	 */
	
	/*
	 * public List<Existencia> getExistencia() { return existencia; } public void
	 * setExistencia(List<Existencia> existencia) { this.existencia = existencia; }
	 */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
