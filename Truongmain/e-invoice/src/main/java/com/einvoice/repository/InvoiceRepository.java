package com.einvoice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.einvoice.model.Invoice;
import com.einvoice.model.User;



public interface InvoiceRepository extends CrudRepository<Invoice, Long>, JpaRepository<Invoice, Long> {
	@Query(value = "SELECT * FROM invoice u WHERE u.id_user = ?1", nativeQuery = true)
	List<Invoice> findByIdUser(User id);
	
	Page<Invoice> findAll(Pageable pageable);
	
	@Query(value = "SELECT * FROM invoice u WHERE u.id_user = ?1 AND u.i_date BETWEEN ?2 AND ?3", nativeQuery = true)
	List<Invoice> findByIdUserAndDateBetween(User id, Date dateStart, Date dateEnd);
	
//	@Query(value = "select * from invoice u where u.id_user = ?#{[0]} and u.date between ?#{[1]} and ?#{[2]} and u.i_type = ?#{[3]}")
//	List<Invoice> findByIdUserAndDateBetweenAndType(User id, Date dateStart, Date dateEnd, String type);
}
