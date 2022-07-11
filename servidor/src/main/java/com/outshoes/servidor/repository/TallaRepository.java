package com.outshoes.servidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.outshoes.servidor.model.Talla;

@Repository
public interface TallaRepository extends JpaRepository<Talla, Long>{

}
