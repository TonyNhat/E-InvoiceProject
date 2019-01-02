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
	
	@Column(name = "amountOfMoney")
	private float amountOfMoney;
	
	@Column(name = "VAT")
	private int VAT;
	
	@Column(name = "createdAt")
	private String createdAt;
	
	@Column(name = "updateAt")
	private String updateAt;
	
	@Column(name = "chargedPeriod")
	private float chargedPeriod;
	
	@Column(name = "userId")
	private int userId;
	
	@Column(name = "limit")
	private float limit;
	
	@Column(name = "typeOfInvoice")
	private String typeOfInvoice;
	
	//End: create table invoice
	
	public Invoice() {
	}

	public Invoice(float amountOfMoney,int VAT, String createdAt,String updateAt,
			float chargedPeriod,int userId,float limit,String typeOfInvoice) {
		this.amountOfMoney = amountOfMoney;
		this.VAT = VAT;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
		this.chargedPeriod = chargedPeriod;
		this.userId = userId;
		this.limit = limit;
		this.typeOfInvoice = typeOfInvoice;		
	}	
	//Start: get-set method
	public float getAmountOfMoney() {
		return amountOfMoney;
	}

	public void setAmountOfMoney(float amountOfMoney) {
		this.amountOfMoney = amountOfMoney;
	}

	public int getVAT() {
		return VAT;
	}

	public void setVAT(int vAT) {
		VAT = vAT;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}

	public float getChargedPeriod() {
		return chargedPeriod;
	}

	public void setChargedPeriod(float chargedPeriod) {
		this.chargedPeriod = chargedPeriod;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public float getLimit() {
		return limit;
	}

	public void setLimit(float limit) {
		this.limit = limit;
	}

	public String getTypeOfInvoice() {
		return typeOfInvoice;
	}

	public void setTypeOfInvoice(String typeOfInvoice) {
		this.typeOfInvoice = typeOfInvoice;
	}

//	public void setId(long id) {
//		this.id = id;
//	}
	
	public long getId() {
		return id;	
	}
	//End: get-set method
	
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", amountOfMoney=" + amountOfMoney + ", VAT=" + VAT + ", createdAt=" + createdAt
				+ ", updateAt=" + updateAt + ", chargedPeriod=" + chargedPeriod + ", userId=" + userId + ", limit="
				+ limit + ", typeOfInvoice=" + typeOfInvoice + "]";
	}
}
