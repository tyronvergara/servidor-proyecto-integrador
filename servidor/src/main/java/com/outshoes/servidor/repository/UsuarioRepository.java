package com.outshoes.servidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.outshoes.servidor.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
