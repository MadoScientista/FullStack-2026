package com.madoscientista.biblioteca.controller;

import org.springframework.web.bind.annotation.RestController;

import com.madoscientista.biblioteca.model.Book;
import com.madoscientista.biblioteca.service.BookService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("api/v1/libros")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }
    
    @GetMapping("/total-libros")
    public String getNBooks(){
        return bookService.getNBooks();
    }

    @GetMapping("/autor/{author}")
    public List<Book> getBookByAuthor(@PathVariable String author){
        return bookService.getBookByAuthor(author);
    }

    @GetMapping("/isbn/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn){
        return bookService.getBookByIsbn(isbn);
    }

    @GetMapping("/year/{year}")
    public List<Book> getBooksByYear(@PathVariable int year){
        return bookService.getBooksByYear(year);
    }

    @PostMapping
    public ResponseEntity<Book> postBook(@Valid @RequestBody Book b) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.postBook(b));
    }

    @DeleteMapping("{id}")
    public String removeBook(@PathVariable int id){
        return bookService.removeBook(id);
    }

    @PutMapping("{id}")
    public Book putBook(@PathVariable int id, @Valid @RequestBody Book book){
        return bookService.putBook(book);
    }


}
