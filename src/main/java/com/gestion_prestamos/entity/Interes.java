package com.gestion_prestamos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "intereses")
public class Interes {
	@EmbeddedId
	private InteresId id;

	@Column( columnDefinition = "decimal(10, 2)" )
	private double price;

	@ManyToOne
	@JoinColumn(name = "id_monto", insertable = false, updatable = false, referencedColumnName = "id")
	private Monto monto;

	@ManyToOne
	@JoinColumn(name = "id_tiempo", insertable = false, updatable = false, referencedColumnName = "id")
	private Tiempo tiempo;

	public InteresId getId() {
		return id;
	}

	public void setId(InteresId id) {
		this.id = id;
	}

	public Monto getMonto() {
		return monto;
	}

	public void setMonto(Monto monto) {
		this.monto = monto;
	}

	public Tiempo getTiempo() {
		return tiempo;
	}

	public void setTiempo(Tiempo tiempo) {
		this.tiempo = tiempo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
