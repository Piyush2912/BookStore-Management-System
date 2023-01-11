package com.piyuh.springbootjpa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.piyuh.springbootjpa.exception.BookNotFoundException;
import com.piyuh.springbootjpa.model.Book;
import com.piyuh.springbootjpa.repository.BookRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	// get all books
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	// create book rest api
	@PostMapping("/books")
	public Book createBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	
	// get book by id rest api
	@GetMapping("/books/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable Long bookId){
		Book book = bookRepository.findById(bookId)
				.orElseThrow(()-> new BookNotFoundException("Book not exist with bookId: " + bookId));
		return ResponseEntity.ok(book);
	}
	
	// update book rest api
	@PutMapping("books/{bookId}")
	public ResponseEntity<Book> updateBook(@PathVariable Long bookId, @RequestBody Book bookDetails){
		Book book = bookRepository.findById(bookId)
				.orElseThrow(()-> new BookNotFoundException("Book not exist with bookId: " + bookId));
		
		book.setBookId(bookDetails.getBookId());
		book.setBookName(bookDetails.getBookName());
		book.setBookAuthor(bookDetails.getBookAuthor());
		
		Book updatedBook = bookRepository.save(book);
		return ResponseEntity.ok(updatedBook);
	}
	
	// delete book rest api
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Map<String, Boolean>> deleteBook(@PathVariable Long bookId){
		Book book = bookRepository.findById(bookId)
				.orElseThrow(()-> new BookNotFoundException("Book not exist with bookId: " + bookId));
		
		bookRepository.delete(book);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}	
	
}
