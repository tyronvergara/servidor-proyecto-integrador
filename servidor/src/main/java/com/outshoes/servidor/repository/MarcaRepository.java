package com.outshoes.servidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.outshoes.servidor.model.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long>{

}
