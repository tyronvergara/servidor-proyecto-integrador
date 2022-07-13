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
	
	
	public Usuario addUser (Usuario usuario) { 
		Usuario tmpUsuario = null;
		
		Optional <Usuario> userByCorreo = usuarioRepository.findByCorreo(usuario.getCorreo());
			
			if (userByCorreo.isPresent()) {
				throw new IllegalStateException("El usuario ya existe");
			} else {
				usuarioRepository.save(usuario);
			}

			return tmpUsuario;
	 }

	public Optional <Usuario> getUser(Long id) {
		return usuarioRepository.findById(id);
	}

	public Usuario delUser(Long id) {
		Usuario tmpUsuario = null;
		
		if(usuarioRepository.existsById(id)) {
			tmpUsuario = usuarioRepository.findById(id).get();
			usuarioRepository.deleteById(id);
		}
		
		return tmpUsuario;
	}

	public Usuario updUser(Long id, String password, String newPassword) {
		Usuario tmpUsuario = null;
		
		if(usuarioRepository.existsById(id)) {
			tmpUsuario = usuarioRepository.findById(id).get();
			if(tmpUsuario.getContrasena().equals(password)) {
				tmpUsuario.setContrasena(newPassword);
				usuarioRepository.save(tmpUsuario);
			}
		}
		
		return tmpUsuario;
	}

	public boolean validateUsuario(Usuario usuario) {
		boolean res = false;
		
			Optional <Usuario> userByCorreo = usuarioRepository.findByCorreo(usuario.getCorreo());
		
			if (userByCorreo.isPresent()) {
				Usuario u = userByCorreo.get();
				if(u.getContrasena().equals(usuario.getContrasena())) {
					res = true;
				}
			}
		return res;
	}
}
