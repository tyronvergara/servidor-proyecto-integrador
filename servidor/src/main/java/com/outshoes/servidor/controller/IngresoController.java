package com.outshoes.servidor.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outshoes.servidor.jwt.config.JwtFilter;
import com.outshoes.servidor.model.Token;
import com.outshoes.servidor.model.Usuario;
import com.outshoes.servidor.service.UsuarioService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="/api/ingreso/")
public class IngresoController {

	private UsuarioService usuarioService;
	
	@Autowired
	public IngresoController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@PostMapping
	public Token ingreso(@RequestBody Usuario usuario) throws ServletException{
		if(usuarioService.validateUsuario(usuario)) {
			return new Token(generateToken(usuario.getCorreo()));
		}
		throw new ServletException("Usuario o contraseña incorrectos");
	}
	
	private String generateToken(String username) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 10);
		return Jwts.builder()
				.setSubject(username)
				.claim("role", "user")
				.setIssuedAt(new Date())
				.setExpiration(calendar.getTime())
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret).compact();
		}// generateToken
	
}
