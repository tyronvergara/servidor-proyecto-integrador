package com.outshoes.servidor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.outshoes.servidor.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	List <Producto> findAllByOrderByIdDesc();
	
}
