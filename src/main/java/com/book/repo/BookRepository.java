package com.book.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.book.model.Book;

import jakarta.transaction.Transactional;

@Repository//This annotation is used to define a repository
public interface BookRepository extends CrudRepository<Book,Integer > {
    
	List<Book>findAllBooksByBname(String bname);
	List<Book>findByBprice(float bprice);
	
	@Query("select b from Book b where b.bprice > ?1")
	List<Book>findAllBooksGreaterPrice(float bprice);
	//mechanism provided by spring data jpa to queriying data from a database
	//used to execute query for repository method it contains jpql or sql to execute
	@Query("select b from Book b where b.bname=?1 and b.bprice=?2")
	List<Book>findBookswithPriceName(String bname,float bprice );
	
	//used to write a jpql for Insert,update,Delete queries this method returns an integer(It provides number of updated query)
	//This annotation accepts two attributes clearAutomatically and flushAutomatically
	@Modifying
	@Transactional//which ensures that that data updation operation will be executed within the transaction
	//if any exception are thrown during the method execution the transaction wll be rolled back and data will not saved on database
	@Query("update Book b set b.bname =?1 where b.bid=?2")
	Integer updateBookNameById(String bname ,Integer id);
}
