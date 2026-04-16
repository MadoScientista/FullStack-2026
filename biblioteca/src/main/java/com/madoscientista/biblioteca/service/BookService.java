package com.madoscientista.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madoscientista.biblioteca.model.Book;
import com.madoscientista.biblioteca.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookService(){
        
    }

    // -------------- Sección GET ----------------------

    // Retorna una lista con los libros prestados y no prestados
    public List<Book> getBooks(){
        return bookRepository.getBooks();
    }

    // Retorna un libro filtrado por id
    public Book getBookById(int id){
        return bookRepository.getBookById(id);
    }

    // Retorna un String con el total de libros disponibles y no disponibles
    public String getNBooks(){
        int n = bookRepository.getBooks().size();
        return "Libros en total: " + String.valueOf(n);
    }

    // Retorna un libro filtrado por isbn
    public Book getBookByIsbn(String isbn){
        return bookRepository.getBookByIsbn(isbn);
    }

    // Retorna una lista con libros filtrados por autor
    public List<Book> getBookByAuthor(String author){
        return bookRepository.getBookByAuthor(author);
    }

    // Retorna una lista con libros filtrados por año de publicación
    public String getTotalBooksByYear(int year){

        return String.valueOf(getBooksByYear(year).size());
    }

    public List<Book> getBooksByYear(int year){
        return bookRepository.getBooksByYear(year);
    }

    // ---------------- Sección POST -----------------------

    public Book postBook(Book b){
        return bookRepository.postBook(b);
    }


     // -------------- Sección DELETE ------------------------

    // Permite eliminar un libro de la lista de libros
    public String removeBook(int b){
        if(bookRepository.removeBook(b)){
            return "Libro eliminado con éxito";
        }

        return "Error al eliminar el libro";
    }


    // ---------------- Sección PUT -------------------

    // Permite actualizar un libro de la lista
    public Book putBook(Book book){
        return bookRepository.putBook(book);
    }

    
}
