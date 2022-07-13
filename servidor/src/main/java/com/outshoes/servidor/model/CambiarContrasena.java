package com.outshoes.servidor.model;

public class CambiarContrasena {
	private String correo;
	private String contrasena;
	private String nuevaContrasena;
	
	public CambiarContrasena(String correo, String contrasena, String nuevaContrasena) {
		super();
		this.correo = correo;
		this.contrasena = contrasena;
		this.nuevaContrasena = nuevaContrasena;
	}
	
	public CambiarContrasena() {}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNuevaContrasena() {
		return nuevaContrasena;
	}

	public void setNuevaContrasena(String nuevaContrasena) {
		this.nuevaContrasena = nuevaContrasena;
	}
	
	
	
}
