package io.dinosauruncle.tacademy.springbooot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.dinosauruncle.tacademy.springbooot.domain.Book;
import io.dinosauruncle.tacademy.springbooot.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/{bookId}")
	public ResponseEntity<Book> findAll(Long bookId){
		Book book = bookService.findById(bookId).orElseThrow(() -> new RuntimeException("Not found: " + bookId));
		return ResponseEntity.ok(book); 
	}
}
