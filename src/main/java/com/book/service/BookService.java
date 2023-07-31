package com.book.service;

import java.security.PublicKey;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.exception.BookAlreadyExistsExcception;
import com.book.exception.BookNotFoundException;
import com.book.model.Book;
import com.book.repo.BookRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//it declares that this class is a service class ,a class that provides a business logic
@Service 
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	//add
	public Book addBook(Book b) {
		boolean status =bookRepo.existsById(b.getBid());
		if(status == false)
			return  bookRepo.save(b);
		else {
			throw new BookAlreadyExistsExcception("Book Already exists with ID:"+b.getBid());
			
		}
	}
	
	//search by id
	public Book searchBookById(int id){
		//optional checks for the availability of the data we search using data inside the parameter
		Optional<Book> op = bookRepo.findById(id);
		try {
			 Book b = op.get();
			 System.out.println("from try block:"+b);
			 return b;
		}catch (NoSuchElementException e) {
			throw new BookNotFoundException("Book Does not exist with id:"+id);
		}
	}
	
	//delete by id
	public Book removeBookById(int id) {
		Book b = searchBookById(id);
		if(b != null) {
			System.out.println("from if condition:"+b);
			bookRepo.delete(b);
			return b;
		}else {
			System.out.println("Book does not exiist with Id:"+id);
			return null;
		}
	}
	
	//update by id
	public Book updateBookById(Book b){
		Book existingBook = searchBookById(b.getBid());
	   if(existingBook!= null) {
		   bookRepo.save(b);
		   return b;
	   }else {
		   System.out.println("Book does not exists with Id:"+b.getBid());
		   return null;
	   }
		
	}
	
	//Get All
	public List<Book> getAllBooks(){
		return (List<Book>) bookRepo.findAll();
	}
	
	//Get BY Name
	public List<Book>getAllBooksByName(String bname){
		return bookRepo.findAllBooksByBname(bname);
	}
	
	//Get BY Id
	public List<Book>getAllBOoksByPrice(float bprice){
		return bookRepo.findByBprice(bprice);
	}
	
	//Get Greater price book
	public List<Book>findAllBooksGreaterPrice(float bprice){
		return bookRepo.findAllBooksGreaterPrice(bprice);
	}
	
	//Get Book with price and name
	public List<Book>findBookWIthPriceName(String bname,float bprice){
		return bookRepo.findBookswithPriceName(bname,bprice);
	}
	
	//Update book name by id
	public int updateBookNameById(String name,int id) {
		return bookRepo.updateBookNameById(name,id);
	}
	
}
