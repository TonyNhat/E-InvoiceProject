package com.einvoice.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.einvoice.message.respone.ResponseMessage;
import com.einvoice.model.Invoice;
import com.einvoice.model.User;
import com.einvoice.repository.InvoiceRepository;
import com.einvoice.repository.UserRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/in")
public class invoiceController {
	
	private static final Logger log = LoggerFactory.getLogger(invoiceController.class);
	
	@Autowired
	InvoiceRepository repository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/invoices")
	public List<Invoice> getAllInvoice(){
		System.out.println("get all invoices");
		
		List<Invoice> _invoice = new ArrayList<>();
		
		repository.findAll().forEach(_invoice::add);
		return _invoice;
	}
	
	@GetMapping("/invoices/get/{id}")
	public Optional<Invoice> getInvoiceByIdUser(@PathVariable("id") long id, @RequestBody User user){
		log.info("get invoice with user [id =" +user.getId()+ "], [name =" + user.getName() + "]");
		
		Optional<Invoice> _invoice = repository.findById(id);
		
		return _invoice;
	}
	
	@GetMapping("/invoices/uget/{user}")
	public List<Invoice> getInvoiceByUsername(@PathVariable("user") String user, @RequestBody User users){
		log.info("get invoice of user");
		
		List<Invoice> _invoice = repository.findByUsername(user);
		
		return _invoice;
	}

	
	//tao invoice ko co username
	@PostMapping(value = "/invoices/create")
	public Invoice postInvoice(@RequestBody Invoice invoice) {

		Invoice _invoice = repository.save(new Invoice(
				invoice.getDate(),
				invoice.getI_type(),
				invoice.getVat(),
				invoice.getTotal(),
				invoice.getGrandTotal()
				));
		return _invoice;		
	}

//	@RequestMapping(value = "/invoice/create", method = RequestMethod.POST)
//	public ResponseEntity<Void> createInvoice(@RequestBody Invoice invoice, UriComponentsBuilder ucBuilder) {
//		log.info("Creating Invoice " + invoice.getId());
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		String username = auth.getName();	
//		Users user = new Users();
//		user = userService.findByName(username);	
//		log.info("Type invoice" + invoice.getIdType());	
//		Customer cus = new Customer();
//		cus = customerService.findByUser(user);	
//		invoice.setIdCustomer(cus);
//		invoiceService.saveInvoice(invoice);
//		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(ucBuilder.path("/invoice/{id}").buildAndExpand(invoice.getId()).toUri());
//		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//	}
	
}
