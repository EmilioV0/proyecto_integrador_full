package com.gestion_prestamos.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "solicitudes_prestamos")
public class SolicitudPrestamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private BigDecimal monto;
	private Integer dias;
	private String estado;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fechaInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fechaFin;

	@Column(columnDefinition = "decimal(10, 2)")
	private BigDecimal pagoDiario;

	@Column(name = "id_prestatario")
	private Integer idPrestatario;

	private Integer idPrestamista;

	@ManyToOne
	@JoinColumn(name = "id_prestatario", insertable = false, updatable = false, referencedColumnName = "id")
	private User prestatario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public BigDecimal getPagoDiario() {
		return pagoDiario;
	}

	public void setPagoDiario(BigDecimal pagoDiario) {
		this.pagoDiario = pagoDiario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdPrestatario() {
		return idPrestatario;
	}

	public void setIdPrestatario(Integer idPrestatario) {
		this.idPrestatario = idPrestatario;
	}

	public Integer getIdPrestamista() {
		return idPrestamista;
	}

	public void setIdPrestamista(Integer idPrestamista) {
		this.idPrestamista = idPrestamista;
	}

	public User getPrestatario() {
		return prestatario;
	}

	public void setPrestatario(User prestatario) {
		this.prestatario = prestatario;
	}

}
