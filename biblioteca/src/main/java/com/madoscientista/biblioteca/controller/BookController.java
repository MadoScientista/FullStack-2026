package com.madoscientista.biblioteca.controller;

import org.springframework.web.bind.annotation.RestController;

import com.madoscientista.biblioteca.model.Book;
import com.madoscientista.biblioteca.service.BookService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("api/v1/libros")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
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

    @PostMapping("/")
    public Book postBook(@RequestBody Book b) {
        return bookService.postBook(b);
    }

    @DeleteMapping("{id}")
    public String removeBook(@PathVariable int id){
        return bookService.removeBook(id);
    }

    @PatchMapping("{id}")
    public Book patchBook(@PathVariable int id, @RequestBody Book book){
        return bookService.patchBook(book);
    }


}
