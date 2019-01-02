package com.javasampleapproach.springrest.mysql.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.springrest.mysql.model.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
//	List<Invoice> findByMoney (float money);
	List<Invoice> findByVAT (int VAT); // tìm kiếm theo VAT
}