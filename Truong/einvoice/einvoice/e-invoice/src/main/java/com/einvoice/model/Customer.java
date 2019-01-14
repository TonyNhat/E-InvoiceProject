package com.einvoice.model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "active")
    private boolean active;

    public Customer(){

    }

    public Customer(String name, int age){
        this.name = name;
        this.age = age;
        this.active = false;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "Customer: [id = " + id + "][name = " + name + "][age = " + age + "][active = " + active + "]";
    }
}