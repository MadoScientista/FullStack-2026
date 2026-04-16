package com.madoscientista.biblioteca.repository;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.madoscientista.biblioteca.model.Book;

@Repository
public class BookRepository {
    private List<Book> bookList = new ArrayList<>();

    public BookRepository(){
        
        bookList.add(new Book(1, "9789569646638", "Fuego y Sangre", "Penguin Random House Grupo Editorial", 2018, "George R. R. Martin", true));
        bookList.add(new Book(2, "9789563494150", "Quique Hache: El Mall Embrujado y Otras Historias", "Sm Ediciones", 2014, "Sergio Gomez", true));
        bookList.add(new Book(3, "9781484256251", "Spring Boot Persistence Best Practices", "Apress", 2020, "Anghel Leonard", true));
        bookList.add(new Book(4, "9789566075752", "Harry Potter y la piedra filosofal", "Salamandra", 2024, "J. K. Rowling", true));
        bookList.add(new Book(5, "9780439139601", "Harry Potter y el prisionero de Azkaban", "Scholastic", 1999, "J. K. Rowling", true));
        bookList.add(new Book(6, "9780439136365", "Harry Potter y el cáliz de fuego", "Scholastic", 2000, "J. K. Rowling", true));
        bookList.add(new Book(7, "9780321127426", "Effective Java", "AddisonWesley", 2008, "Joshua Bloch", true));
        bookList.add(new Book(8, "9780134685991", "Clean Architecture", "Prentice Hall", 2017, "Robert C. Martin", true));
        bookList.add(new Book(9, "9780201633610", "Design Patterns", "AddisonWesley", 1994, "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", true));
        bookList.add(new Book(10, "9780132350884", "Clean Code", "Prentice Hall", 2008, "Robert C. Martin", true));
        bookList.add(new Book(11, "9781491950357", "Learning Spring Boot 2.0", "O'Reilly Media", 2018, "Greg L. Turnquist", true));
        bookList.add(new Book(12, "9781617292545", "Spring  Microservices in Action", "Manning Publications", 2017, "John Carnell", true));
        bookList.add(new Book(13, "9781786463784", "Spring Boot 2.0 Projects", "Packt Publishing", 2018, "Mohamed Sanaulla", true));
        bookList.add(new Book(14, "9781787125999", "Spring Boot 2.0 Cookbook", "Packt Publishing", 2018, "Alex Antonov", true));
        bookList.add(new Book(15, "9781787125999", "Spring Boot 2.0 Cookbook", "Packt Publishing", 2018, "Alex Antonov", true));

    }


    // ----------------- Sección GET ---------------------

    // Retorna una lista con los libros prestados y no prestados
    public List<Book> getBooks(){
        return bookList;
    }

    // Retorna un libro filtrado por id
    public Book getBookById(int id){
        
        for(Book b : bookList){
            if(b.getId() == id){
                return b;
            }
        }
        return null;
    }

    // Retorna un libro filtrado por isbn
    public Book getBookByIsbn(String isbn){

        for(Book b: bookList){
            if(b.getIsbn().equals(isbn)){
                return b;
            }
        }

        return null;
    }

    // Retorna una lista con libros filtrados por autor
    public List<Book> getBookByAuthor(String author){

        List<Book> books = new ArrayList<>();

        for(Book b: bookList){
            if(b.getAuthor().equals(author)){
                books.add(b);
            }
        }

        return books;
    }

    // Retorna una lista con libros filtrados por año de publicación
    public List<Book> getBooksByYear(int year){
        List<Book> books = new ArrayList<>();

        for(Book b: bookList){
            if(b.getPublicationDate() == year){
                books.add(b);
            }
        }

        return books;
    }

    // -------------- Sección DELETE ------------------------

    // Permite eliminar un libro de la lista de libros
    public boolean removeBook(int id){
        Book b = getBookById(id);
        if(b!= null){
            bookList.remove(b);
            return true;
        }

        return false;
    }


    // -------------- Sección POST ---------------------

    // Permite agregar un libro a la lista de libros
    public Book postBook(Book book){
        bookList.add(book);
        return book;
    }


    // ---------------- Sección PUT -------------------

    // Permite actualizar un libro de la lista
    public Book putBook(Book book){

        for(Book b: bookList){
            if(b.getId() == book.getId()){
                b.setAuthor(book.getAuthor());
                b.setEditorial(book.getEditorial());
                b.setIsbn(book.getIsbn());
                b.setTitle(book.getTitle());
                b.setPublicationDate(book.getPublicationDate());
                
                return book;
            }
        }

        return null;
    }

}
