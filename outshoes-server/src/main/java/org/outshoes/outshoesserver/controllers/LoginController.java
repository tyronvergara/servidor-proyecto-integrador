package org.outshoes.outshoesserver.controllers;

import org.outshoes.outshoesserver.UsuarioLogin;
import org.outshoes.outshoesserver.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path="/api/ingreso/")
public class LoginController {
	
	private final UsuarioServices usuarioServices;
	
	@Autowired
	public LoginController(UsuarioServices usuarioServices) {
		this.usuarioServices = usuarioServices;
	}
	
	@PostMapping
	public UsuarioLogin loginUsuario(@RequestBody UsuarioLogin usuarioLogin) {
		return usuarioServices.loginUsuario(usuarioLogin);
	}
	
}
