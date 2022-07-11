package com.outshoes.servidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.outshoes.servidor.model.Existencia;

@Repository
public interface ExistenciaRepository extends JpaRepository<Existencia, Long>{

}
