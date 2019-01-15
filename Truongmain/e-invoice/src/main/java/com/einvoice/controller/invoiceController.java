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
	
	@GetMapping("/invoices/get/{idUser}")
	public List<Invoice> getInvoiceByIdUser(@PathVariable("idUser") User idUser){
		log.info("get invoice with user [id =" +idUser.getId()+ "], [name =" + idUser.getName() + "]");
		
		List<Invoice> _invoice = repository.findByIdUser(idUser);
		if(_invoice != null) {
			return _invoice;
		}
		return null;
	}
	


	@GetMapping("/invoices/create")
	public String getID(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String id = auth.getName();
		
		
		return id;
	}
	
}
