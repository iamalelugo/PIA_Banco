package com.BancoLALR.springboot.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name = "tarjetas")
public class Tarjeta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	@NotEmpty
	private String numerodeTarjeta;
	
	@Column (name = "icv", nullable = false ,length = 3)
	@NotEmpty
	private String icv;
	
	@Column (name = "fecha_de_vencimiento")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechavencimiento;
	
	@JoinColumn (name = "cuenta", referencedColumnName = "id",nullable = false)
	@ManyToOne (optional = false, fetch = FetchType.LAZY)
	private Cuenta cuenta;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumerodeTarjeta() {
		return numerodeTarjeta;
	}

	public void setNumerodeTarjeta(String numerodeTarjeta) {
		this.numerodeTarjeta = numerodeTarjeta;
	}

	public String getIcv() {
		return icv;
	}

	public void setIcv(String icv) {
		this.icv = icv;
	}

	public Date getFechavencimiento() {
		return fechavencimiento;
	}

	public void setFechavencimiento(Date fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
