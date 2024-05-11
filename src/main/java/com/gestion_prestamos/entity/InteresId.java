package com.gestion_prestamos.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class InteresId implements Serializable {

	private static final long serialVersionUID = 6076291259726706100L;

	@Column(name = "id_monto")
	private Integer idMonto;

	@Column(name = "id_tiempo")
	private Integer idTiempo;

	public Integer getIdMonto() {
		return idMonto;
	}

	public void setIdMonto(Integer idMonto) {
		this.idMonto = idMonto;
	}

	public Integer getIdTiempo() {
		return idTiempo;
	}

	public void setIdTiempo(Integer idTiempo) {
		this.idTiempo = idTiempo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMonto, idTiempo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		InteresId other = (InteresId) obj;
		return Objects.equals(idMonto, other.idMonto) && Objects.equals(idTiempo, other.idTiempo);
	}


}
