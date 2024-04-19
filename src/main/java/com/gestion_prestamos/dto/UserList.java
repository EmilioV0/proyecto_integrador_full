package com.gestion_prestamos.dto;

public class UserList {
	private Integer id;
	private String DNI;
	private String nombre;
	private String apellido;
	private String rol;
	private String telefono;
	private String username;

	public UserList() {}
	
	public UserList(Integer id, String dNI, String nombre, String apellido, String rol, String telefono, String username) {
		this.id = id;
		DNI = dNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rol = rol;
		this.telefono = telefono;
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserList [id=" + id + ", DNI=" + DNI + ", nombre=" + nombre + ", apellido=" + apellido + ", rol=" + rol
				+ ", telefono=" + telefono + ", username=" + username + "]";
	}
	
	
	
}
