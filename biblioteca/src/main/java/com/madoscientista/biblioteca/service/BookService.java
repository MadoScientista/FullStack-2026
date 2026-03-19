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

    public List<Book> getBooks(){
        return bookRepository.getBooks();
    }

    public Book postBook(Book b){
        return bookRepository.postBook(b);
    }

    public Book getBookById(int id){
        return bookRepository.getBookById(id);
    }

    public Book getBookByIsbn(String isbn){
        return bookRepository.getBookByIsbn(isbn);
    }

    public String getTotalBooksByYear(int year){

        return String.valueOf(getBooksByYear(year).size());
    }


    public List<Book> getBookByAuthor(String author){
        return bookRepository.getBookByAuthor(author);
    }

    public List<Book> getBooksByYear(int year){
        return bookRepository.getBooksByYear(year);
    }

    public String removeBook(int b){
        if(bookRepository.removeBook(b)){
            return "Libro eliminado con éxito";
        }

        return "Error al eliminar el libro";
    }

    public Book patchBook(Book book){
        return bookRepository.patchBook(book);
    }

    public String getNBooks(){
        int n = bookRepository.getBooks().size();
        return "Libros en total: " + String.valueOf(n);
    }
}
