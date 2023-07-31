package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.model.Book;
import com.book.service.BookService;

@RestController//used to create a restfull webservice its a combination of @Contoller and @ResponseBody
//@Controller it makes our class to handle the incomming  request and  @ResponseBody IT Tells mvc controller to automatically convert Java object in to Json send that in to client
//RestController internally uses HTTP message convertors  and this annotation won't work for spring mvc web application it only works for creating spring mvc restfull webservices
//@RestController introduced in Spring4.0 before 4.0 we have to use Annotaion on each method.
@RequestMapping("/book")
//mapping web request in to spring controller methods(Request Handling Methods)that means it mapping the corresponding http request into corresponding handler methods.
//used to define base URL for all the rest API's used in the controller.we can also provide multiple URL'S for specific REST API methods,
public class BookController 
{
        @Autowired BookService bookService;
        
        @PostMapping
        public Book addBook(@RequestBody Book b) {
        	  return (Book) bookService.addBook(b);
        }
        
        @GetMapping("/bookid/{id}")
        public Book searchBookById(@PathVariable("id")int bid) {
        	return bookService.searchBookById(bid);
        }
        
        
        //@PathVariable it automatically retrieves the path variable into method parameter of REST End POint
        @DeleteMapping("/bookid/{id}")
        public Book removeBookById(@PathVariable int id) {
            return bookService.removeBookById(id);
        }

        
        @PutMapping
        //@RequestBody automatically Deserializes(convert Machine code into Entity object) the body of the http request. 
        public Book updateBookById(@RequestBody Book b) {
        	return bookService.updateBookById(b);
        }
        
        @GetMapping
        public List<Book>getAllBooks(){
        	return bookService.getAllBooks();
        }
        @GetMapping("/bookname/{bname}")
        public List<Book>getAllBooksBYname(@PathVariable String bname){
        	return bookService.getAllBooksByName(bname);
        }
        @GetMapping("/bookprice/{bprice}")
        public List<Book>getAllBooksByPrice(@PathVariable float bprice){
        	return bookService.getAllBOoksByPrice(bprice);
        }
        
        @GetMapping("/bookpricegreater/{bprice}")
        public List<Book>findAllBooksGreaterPrice(@PathVariable float bprice){
        	return bookService.findAllBooksGreaterPrice(bprice);
        }
        
        @GetMapping("/booksWithPriceName")
        //@@RequestParam it automatically retieves the query parameter int the parameter of REST api methods
        public List<Book>findBooksWithPriceName(@RequestParam("bname")String bname,@RequestParam("bprice") float bprice){
        	return bookService.findBookWIthPriceName(bname, bprice);
        }
        
        @PutMapping("/nameById")
        public int updateBookNameById(@RequestParam("bname")String name,@RequestParam("id")int id) {
        	return bookService.updateBookNameById(name, id);
        }
}
