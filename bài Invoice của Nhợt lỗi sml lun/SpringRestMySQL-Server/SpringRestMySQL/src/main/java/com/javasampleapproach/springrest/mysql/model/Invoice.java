package com.javasampleapproach.springrest.mysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice {
	// Start: create table Invoice
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "amount")
	private float amount;
	
	@Column(name = "VAT")
	private int VAT;
	
	@Column(name = "createdat")
	private String createdat;
		
	@Column(name = "chargedperiod")
	private float chargedperiod;
	
	@Column(name = "userid")
	private int userid;
	
	@Column(name = "limit")
	private float limit;
	
	@Column(name = "type")
	private String type;
	
	//End: create table invoice
	
	public Invoice() {
	}
	
	
	public Invoice(float amount, int VAT, String createdat, float chargedperiod, int userid, float limit,
			String type) {
		
		this.amount = amount;
		this.VAT = VAT;
		this.createdat = createdat;
		this.chargedperiod = chargedperiod;
		this.userid = userid;
		this.limit = limit;
		this.type = type;
	}



	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
	}


	public int getVAT() {
		return VAT;
	}


	public void setVAT(int vAT) {
		VAT = vAT;
	}

	public String getCreatedat() {
		return createdat;
	}


	public void setCreatedat(String createdat) {
		this.createdat = createdat;
	}


	public float getChargedperiod() {
		return chargedperiod;
	}


	public void setChargedperiod(float chargedperiod) {
		this.chargedperiod = chargedperiod;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public float getLimit() {
		return limit;
	}


	public void setLimit(float limit) {
		this.limit = limit;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Invoice [id=" + id + ", amount=" + amount + ", VAT=" + VAT + ", createdat=" + createdat
				+ ", chargedperiod=" + chargedperiod + ", userid=" + userid + ", limit=" + limit + ", type=" + type
				+ "]";
	}
}
