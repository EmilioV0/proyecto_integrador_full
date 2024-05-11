package com.gestion_prestamos.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String dni;
	private String nombre;
	private String apellido;
	private String login;
	private String password;
	private String email;
	private String telefono;

	@Column(name = "id_rol")
	private Integer idRol;

	@Column(name = "id_grupo")
	private Integer idGrupo;

	@Column(name = "id_zona")
	private Integer idZona;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rol", insertable = false, updatable = false, referencedColumnName = "id")
	private Rol rol;

	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "id_grupo", insertable = false, updatable = false, referencedColumnName = "id")
	private List<User> subordinados;

	@ManyToOne
	@JoinColumn(name = "id_zona", insertable = false, updatable = false, referencedColumnName = "id")
	private Zona zona;

	public User() {}

	public User(Integer id, String dNI, String nombre, String apellido, String login, String password, String email,
			String telefono, Integer idRol, Integer idGrupo, Integer idZona, Rol rol, List<User> subordinados,
			Zona zona) {
		this.id = id;
		this.dni = dNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.login = login;
		this.password = password;
		this.email = email;
		this.telefono = telefono;
		this.idRol = idRol;
		this.idGrupo = idGrupo;
		this.idZona = idZona;
		this.rol = rol;
		this.subordinados = subordinados;
		this.zona = zona;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public Integer getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	public Integer getIdZona() {
		return idZona;
	}

	public void setIdZona(Integer idZona) {
		this.idZona = idZona;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<User> getSubordinados() {
		return subordinados;
	}

	public void setSubordinados(List<User> subordinados) {
		this.subordinados = subordinados;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public String getDNI() {
		return dni;
	}

	public void setDNI(String DNI) {
		this.dni = DNI ;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", DNI=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", login=" + login
				+ ", password=" + password + ", email=" + email + ", telefono=" + telefono + ", idRol=" + idRol
				+ ", idGrupo=" + idGrupo + ", idZona=" + idZona +  "]";
	}



}
