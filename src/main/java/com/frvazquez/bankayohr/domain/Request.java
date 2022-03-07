package com.frvazquez.bankayohr.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Request implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String ipOrigen;
	private Date fecha;
	private String metodo;

	public Request() {
	}

	public Request(Long id, String ipOrigen, Date fecha, String metodo) {
		super();
		this.id = id;
		this.ipOrigen = ipOrigen;
		this.fecha = fecha;
		this.metodo = metodo;
	}

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	@Column(name = "ip_origen")
	public String getIpOrigen() {
		return ipOrigen;
	}

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFecha() {
		if (fecha == null)
			fecha = new Date(System.currentTimeMillis());
		return fecha;
	}

	@Column
	public String getMetodo() {
		return metodo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIpOrigen(String ipOrigen) {
		this.ipOrigen = ipOrigen;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", ipOrigen=" + ipOrigen + ", fecha=" + fecha + ", metodo=" + metodo + "]";
	}

}
