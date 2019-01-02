package com.javasampleapproach.springrest.mysql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.springrest.mysql.model.Invoice;
import com.javasampleapproach.springrest.mysql.repo.InvoiceRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class InvoiceController {
	@Autowired
	InvoiceRepository repository;
 
	@GetMapping("/invoices")
	public List<Invoice> getAllInvoices() {
		System.out.println("Get all Invoices...");
 
		List<Invoice> invoices = new ArrayList<>();
		repository.findAll().forEach(invoices::add);
 
		return invoices;
	}
	//POST create method
	@PostMapping(value = "/invoices/create")
	public Invoice postInvoice(@RequestBody Invoice invoice) {
 
		Invoice _invoice = repository.save(new Invoice(invoice.getAmountOfMoney(),invoice.getVAT(),invoice.getCreatedAt(),
				invoice.getUpdateAt(),invoice.getChargedPeriod(),invoice.getUserId(),invoice.getLimit(),
				invoice.getTypeOfInvoice()));
		return _invoice;
	}
	//DELETE delete ID method
	@DeleteMapping("/invoices/{id}")
	public ResponseEntity<String> deleteInvoice(@PathVariable("id") long id) {
		System.out.println("Delete Invoice with ID = " + id + "...");
 
		repository.deleteById(id);
 
		return new ResponseEntity<>("Invoice has been deleted!", HttpStatus.OK);
	}
	//DELETE delete ALL invoice method
	@DeleteMapping("/invoices/delete")
	public ResponseEntity<String> deleteAllInvoices() {
		System.out.println("Delete All Invoices...");
 
		repository.deleteAll();
 
		return new ResponseEntity<>("All invoices have been deleted!", HttpStatus.OK);
	}
	//GET get method
	@GetMapping(value = "invoices/VAT/{VAT}")
	public List<Invoice> findByVAT(@PathVariable int VAT) {
 
		List<Invoice> invoices = repository.findByVAT(VAT);
		return invoices;
	}
	//PUT put ID method
	@PutMapping("/invoices/{id}")
	public ResponseEntity<Invoice> updateInvoice(@PathVariable("id") long id, @RequestBody Invoice invoice) {
		System.out.println("Update Invoice with ID = " + id + "...");
 
		Optional<Invoice> invoiceData = repository.findById(id);
 
		if (invoiceData.isPresent()) {
			Invoice _invoice = invoiceData.get();
			_invoice.setAmountOfMoney(invoice.getAmountOfMoney());
			_invoice.setVAT(invoice.getVAT());
			_invoice.setCreatedAt(invoice.getCreatedAt());
			_invoice.setUpdateAt(invoice.getUpdateAt());
			_invoice.setChargedPeriod(invoice.getChargedPeriod());
			_invoice.setUserId(invoice.getUserId());
			_invoice.setLimit(invoice.getLimit());
			_invoice.setTypeOfInvoice(invoice.getTypeOfInvoice());
			return new ResponseEntity<>(repository.save(_invoice), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
	
