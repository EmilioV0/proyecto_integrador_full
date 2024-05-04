package com.gestion_prestamos.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table("")
public class prestamos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Double Monto;
	private Date FechaInicio;
	private Date FechaFin;
	private Integer Dias;
	private Double PagoDiario;
	public prestamos(Integer id, Double monto, Date fechaInicio, Date fechaFin, Integer dias, Double pagoDiario) {
		super();
		this.id = id;
		Monto = monto;
		FechaInicio = fechaInicio;
		FechaFin = fechaFin;
		Dias = dias;
		PagoDiario = pagoDiario;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getMonto() {
		return Monto;
	}
	public void setMonto(Double monto) {
		Monto = monto;
	}
	public Date getFechaInicio() {
		return FechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		FechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return FechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		FechaFin = fechaFin;
	}
	public Integer getDias() {
		return Dias;
	}
	public void setDias(Integer dias) {
		Dias = dias;
	}
	public Double getPagoDiario() {
		return PagoDiario;
	}
	public void setPagoDiario(Double pagoDiario) {
		PagoDiario = pagoDiario;
	}
	
	
	
	
	
}
