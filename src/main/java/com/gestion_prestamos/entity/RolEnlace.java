package com.gestion_prestamos.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rol_enlaces")
public class RolEnlace {
	@EmbeddedId
	private RolEnlacePK id;

	@ManyToOne
	@JoinColumn(name = "id_rol", insertable = false, updatable = false, referencedColumnName = "id")
	private Rol rol;

	@ManyToOne
	@JoinColumn(name = "id_enlace", insertable = false, updatable = false, referencedColumnName = "id")
	private Enlace enlace;

	public RolEnlacePK getId() {
		return id;
	}

	public void setId(RolEnlacePK id) {
		this.id = id;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Enlace getEnlace() {
		return enlace;
	}

	public void setEnlace(Enlace enlace) {
		this.enlace = enlace;
	}
}
