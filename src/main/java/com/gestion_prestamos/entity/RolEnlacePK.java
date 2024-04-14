package com.gestion_prestamos.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class RolEnlacePK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id_rol;
	private Integer id_enlace;
	
	@Override
	public int hashCode() {
		return Objects.hash(id_enlace, id_rol);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolEnlacePK other = (RolEnlacePK) obj;
		return Objects.equals(id_enlace, other.id_enlace) && Objects.equals(id_rol, other.id_rol);
	}
	
	
}
