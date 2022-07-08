package org.outshoes.outshoesserver.services;

import java.util.ArrayList;

import org.outshoes.outshoesserver.Usuario;
import org.outshoes.outshoesserver.UsuarioLogin;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServices {
	
	public ArrayList<Usuario> lista = new ArrayList<Usuario>();

	public UsuarioServices() {
		lista.add(new Usuario("papitas123", "Jorge", "Ramirez", "Alvarado", "5526781321", "jorge@gmail.com", 
				"1998-06-06", 1, "Enrique Segoviano", null, "Estado de México", "Ecatepec", "55434"));
	}
	
	public UsuarioLogin loginUsuario(UsuarioLogin usuarioLogin) {
		return usuarioLogin;
	}
	
	public Usuario addUsuario(Usuario usuario) {
		lista.add(usuario);
		return usuario;
	}
	
}
