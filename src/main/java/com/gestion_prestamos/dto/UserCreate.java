package com.gestion_prestamos.dto;

public class UserCreate {
	private String DNI;
	private String nombre;
	private String apellido;
	private String login;
	private String password;
	private String email;
	private String telefono;
	private Integer idZona;

	public UserCreate() {
	}

	public UserCreate(String dNI, String nombre, String apellido, String login, String password, String email,
			String telefono, Integer idZona) {
		DNI = dNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.login = login;
		this.password = password;
		this.email = email;
		this.telefono = telefono;
		this.idZona = idZona;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getIdZona() {
		return idZona;
	}

	public void setIdZona(Integer idZona) {
		this.idZona = idZona;
	}
}
