package com.outshoes.servidor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.outshoes.servidor.model.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long>{

	List <Inventario> findByProducto_id(Long id);
	
}
