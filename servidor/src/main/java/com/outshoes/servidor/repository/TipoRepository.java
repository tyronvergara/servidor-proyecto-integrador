package com.outshoes.servidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.outshoes.servidor.model.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long>{

}
