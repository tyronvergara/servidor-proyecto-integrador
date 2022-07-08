package org.outshoes.outshoesserver;

public class Usuario {
	private int idUsuario;
	private String contrasenaUsuario;
	private String nombreUsuario;
	private String apellidopUsuario;
	private String apellidomUsuario;
	private String telefonoUsuario;
	private String correoUsuario;
	private String nacimientoUsuario;
	private int tipoUsuario;
	private String lineaunoDireccion;
	private String lineadosDireccion;
	private String estadoDireccion;
	private String ciudadDireccion;
	private String cpDireccion;
	private static int total = 0;
	
	public Usuario(String contrasenaUsuario, String nombreUsuario, String apellidopUsuario,
			String apellidomUsuario, String telefonoUsuario, String correoUsuario, String nacimientoUsuario,
			int tipoUsuario, String lineaunoDireccion, String lineadosDireccion, String estadoDireccion,
			String ciudadDireccion, String cpDireccion) {
		super();
		this.contrasenaUsuario = contrasenaUsuario;
		this.nombreUsuario = nombreUsuario;
		this.apellidopUsuario = apellidopUsuario;
		this.apellidomUsuario = apellidomUsuario;
		this.telefonoUsuario = telefonoUsuario;
		this.correoUsuario = correoUsuario;
		this.nacimientoUsuario = nacimientoUsuario;
		this.tipoUsuario = tipoUsuario;
		this.lineaunoDireccion = lineaunoDireccion;
		this.lineadosDireccion = lineadosDireccion;
		this.estadoDireccion = estadoDireccion;
		this.ciudadDireccion = ciudadDireccion;
		this.cpDireccion = cpDireccion;
		total++;
		this.idUsuario = total;
	}

	public Usuario () {
		total++;
		this.idUsuario = total;
	}
	
	public String getContrasenaUsuario() {
		return contrasenaUsuario;
	}
	public void setContrasenaUsuario(String contrasenaUsuario) {
		this.contrasenaUsuario = contrasenaUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getApellidopUsuario() {
		return apellidopUsuario;
	}
	public void setApellidopUsuario(String apellidopUsuario) {
		this.apellidopUsuario = apellidopUsuario;
	}
	public String getApellidomUsuario() {
		return apellidomUsuario;
	}
	public void setApellidomUsuario(String apellidomUsuario) {
		this.apellidomUsuario = apellidomUsuario;
	}
	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}
	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}
	public String getCorreoUsuario() {
		return correoUsuario;
	}
	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}
	public String getNacimientoUsuario() {
		return nacimientoUsuario;
	}
	public void setNacimientoUsuario(String nacimientoUsuario) {
		this.nacimientoUsuario = nacimientoUsuario;
	}
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getLineaunoDireccion() {
		return lineaunoDireccion;
	}
	public void setLineaunoDireccion(String lineaunoDireccion) {
		this.lineaunoDireccion = lineaunoDireccion;
	}
	public String getLineadosDireccion() {
		return lineadosDireccion;
	}
	public void setLineadosDireccion(String lineadosDireccion) {
		this.lineadosDireccion = lineadosDireccion;
	}
	public String getEstadoDireccion() {
		return estadoDireccion;
	}
	public void setEstadoDireccion(String estadoDireccion) {
		this.estadoDireccion = estadoDireccion;
	}
	public String getCiudadDireccion() {
		return ciudadDireccion;
	}
	public void setCiudadDireccion(String ciudadDireccion) {
		this.ciudadDireccion = ciudadDireccion;
	}
	public String getCpDireccion() {
		return cpDireccion;
	}
	public void setCpDireccion(String cpDireccion) {
		this.cpDireccion = cpDireccion;
	}

	
}
