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


    // ---------- Sección GET ---------------

    // Devuelvela lista de libros disponibles
    @GetMapping
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    // Devuelve un libro filtrado por id
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        if(bookService.getBookById(id) != null){
            return ResponseEntity.ok(bookService.getBookById(id));
        }

        return ResponseEntity.notFound().build();
    }
    

    // Retorna un string con el total de libros disponibles
    @GetMapping("/total-libros")
    public String getNBooks(){
        return bookService.getNBooks();
    }

    // Retorna un libro filtrado por autor

    @GetMapping("/autor/{author}")
    public List<Book> getBookByAuthor(@PathVariable String author){
        return bookService.getBookByAuthor(author);
    }


    // Retorna un libro filtrado por isbn
    @GetMapping("/isbn/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn){
        return bookService.getBookByIsbn(isbn);
    }


    // Devuelve una lista de libros filtrados por año de publicación
    @GetMapping("/year/{year}")
    public List<Book> getBooksByYear(@PathVariable int year){
        return bookService.getBooksByYear(year);
    }

    // ------------- Sección POST --------------

    // Agrega un libro a la lista de libros
    // Valida que los elementos del libro sean correctos
    @PostMapping
    public ResponseEntity<?> postBook(@Valid @RequestBody Book b) {

        if(bookService.postBook(b) != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(bookService.postBook(b));
        }
        
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("El libro no existe o se encuentra en préstamo");
    }

    // ----------- Sección DELETE ----------------

    // Elimina un libro filtrado por id
    @DeleteMapping("{id}")
    public ResponseEntity<?> removeBook(@PathVariable int id){

        if(bookService.getBookById(id) != null){
            bookService.removeBook(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
        
    }

    // ----------- Sección PUT ------------------
    
    // Actualiza un libro filtrado por id
    @PutMapping("{id}")
    public Book putBook(@PathVariable int id, @Valid @RequestBody Book book){
        return bookService.putBook(book);
    }


}
