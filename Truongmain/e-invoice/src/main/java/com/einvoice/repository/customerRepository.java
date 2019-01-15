package com.einvoice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.einvoice.model.Customer;
import com.einvoice.model.User;

public interface customerRepository extends CrudRepository<Customer, Long>{
	public List<Customer> findByAge(int age);
}
