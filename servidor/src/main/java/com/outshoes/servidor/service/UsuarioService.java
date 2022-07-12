package com.outshoes.servidor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.outshoes.servidor.model.Usuario;
import com.outshoes.servidor.repository.UsuarioRepository;

@Service

public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService (UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<Usuario> getAllUsers () {
		return usuarioRepository.findAll();
	}
	
	
	public String addUser (Usuario usuario) { 
		
		Usuario n = new Usuario();
		
		n.setCorreo(usuario.getCorreo());
		n.setContrasena(usuario.getContrasena());
		n.setNombre(usuario.getNombre());
		n.setApellidop(usuario.getApellidop());
		n.setApellidom(usuario.getApellidom());
		n.setTipo(usuario.getTipo());
		//n.setTipo_id(usuario.getTipo_id());
	  
		usuarioRepository.save(n); 
		return "Usuario agregado"; 
	 }

	public Optional <Usuario> getUser(Long id) {
		return usuarioRepository.findById(id);
	}

	public String delUser(Long id) {
		usuarioRepository.deleteById(id);
		return "Usuario borrado";
	}

	public String updUser(Long id, Usuario newUsuario) {
	    usuarioRepository.findById(id)
	    	      .map(usuario -> {
	    	    	  usuario.setCorreo(newUsuario.getCorreo());
	    	    	  usuario.setContrasena(newUsuario.getContrasena());
	    	    	  usuario.setNombre(newUsuario.getNombre());
	    	    	  usuario.setApellidop(newUsuario.getApellidop());
	    	    	  usuario.setApellidom(newUsuario.getApellidom());
	    	    	  usuario.setDireccionuno(newUsuario.getDireccionuno());
	    	    	  usuario.setDirecciondos(newUsuario.getDirecciondos());
	    	    	  usuario.setEstado(newUsuario.getEstado());
	    	    	  usuario.setCiudad(newUsuario.getCiudad());
	    	    	  usuario.setCp(newUsuario.getCp());
	    	    	  //usuario.setTipo_id(newUsuario.getTipo_id());
	    	    	  usuario.setTipo(newUsuario.getTipo());
	    	    	  return usuarioRepository.save(usuario);
	    	      })
	    	      .orElseGet(() -> {
	    	        return usuarioRepository.save(newUsuario);
	    	      });
	    
	    return "Usuario actualizado o creado";
	}
}
