package com.outshoes.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outshoes.servidor.model.CambiarContrasena;
import com.outshoes.servidor.model.Usuario;
import com.outshoes.servidor.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping(path="/api/usuario/")
public class UsuarioController {

	private final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController (UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	 @GetMapping(path="todo")
	 public List<Usuario> getAllUsers() { 
		 return usuarioService.getAllUsers(); 
	 }
	 
	 @GetMapping(path="{Id}")
	 public Optional<Usuario> getUser(@PathVariable("Id") Long id) {
		 return usuarioService.getUser(id);
	 }
		
	 @PostMapping(path="agregar")
	 public Usuario addUser (@RequestBody Usuario usuario) { 
		 return usuarioService.addUser(usuario); 
	 }
	 
	 @DeleteMapping(path="{Id}")
	 public Usuario deleteUser (@PathVariable("Id") Long id) {
		 return usuarioService.delUser(id);
	 }
	 
	 @PutMapping(path="{Id}")
	 public Usuario updateUser (@PathVariable("Id") Long id, @RequestBody CambiarContrasena cambiarContrasena) {
		return usuarioService.updUser(id, cambiarContrasena.getContrasena(), cambiarContrasena.getNuevaContrasena()); 
	 }
}
