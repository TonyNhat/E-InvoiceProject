package com.einvoice.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "invoice")
public class Invoice implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Basic(optional = false)
	@Temporal(TemporalType.DATE)
	@Column(name = "i_date")
	private Date date;
	
	@Basic(optional = false)
	@Column(name = "i_type")
	private String i_type;
	
	@Basic(optional = false)
	@Column(name = "vat")
	private float vat;
	
	@Basic(optional = false)
	@Column(name = "grand_total")
	private BigDecimal grandTotal;
	
	@Basic(optional = false)
	@Column(name = "total")
	private BigDecimal total;
	


	@JsonIgnore
	@JoinColumn(name = "id_user", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private User idUser;
	
	public Invoice() {
	}

	public Invoice(Long id) {
		this.id = id;
	}

	public Invoice(Long id, Date date, String i_type, float vat, BigDecimal total, BigDecimal grandTotal) {
		this.id = id;
		this.date = date;
		this.i_type = i_type;
		this.vat = vat;
		this.total = total;
		this.grandTotal = grandTotal;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getI_type() {
		return i_type;
	}

	public void setI_type(String i_type) {
		this.i_type = i_type;
	}

	public float getVat() {
		return vat;
	}

	public void setVat(float vat) {
		this.vat = vat;
	}

	public BigDecimal getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}
}
