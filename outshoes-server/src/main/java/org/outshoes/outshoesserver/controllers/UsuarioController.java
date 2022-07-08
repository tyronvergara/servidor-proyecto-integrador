package org.outshoes.outshoesserver.controllers;

import org.outshoes.outshoesserver.Usuario;
import org.outshoes.outshoesserver.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path="/api/registro/")
public class UsuarioController {
	
	private final UsuarioServices usuarioServices;
	
	@Autowired
	public UsuarioController(UsuarioServices usuarioServices) {
		this.usuarioServices = usuarioServices;
	}
	
	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario	usuario) {
		return usuarioServices.addUsuario(usuario);
	}
	
}
