package com.madoscientista.biblioteca.repository;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.madoscientista.biblioteca.model.Book;

@Repository
public class BookRepository {
    private List<Book> bookList = new ArrayList<>();

    public BookRepository(){
        bookList.add(new Book(1, "1-isbn", "Título 1", "Sam-1", "Mi editorial 1", 2001));
        bookList.add(new Book(2, "2-isbn", "Título 2", "Sam - 2", "Mi editorial 2", 2002));
        bookList.add(new Book(3, "3-isbn", "Título 3", "Sam - 3", "Mi editorial 3", 2002));
        bookList.add(new Book(4, "4-isbn", "Título 4", "nati - 4", "Mi editorial 4", 2006));
        bookList.add(new Book(5, "5-isbn", "Título 5", "nati - 5", "Mi editorial 5", 2003));

    }

    public List<Book> getBooks(){
        return bookList;
    }

    public Book getBookById(int id){
        
        for(Book b : bookList){
            if(b.getId() == id){
                return b;
            }
        }
        return null;
    }

    public Book getBookByIsbn(String isbn){

        for(Book b: bookList){
            if(b.getIsbn().equals(isbn)){
                return b;
            }
        }

        return null;
    }

    public List<Book> getBookByAuthor(String author){

        List<Book> books = new ArrayList<>();

        for(Book b: bookList){
            if(b.getAuthor().equals(author)){
                books.add(b);
            }
        }

        return books;
    }

    public List<Book> getBooksByYear(int year){
        List<Book> books = new ArrayList<>();

        for(Book b: bookList){
            if(b.getPublicationDate() == year){
                books.add(b);
            }
        }

        return books;
    }

    public boolean removeBook(int id){
        Book b = getBookById(id);
        if(b!= null){
            bookList.remove(b);
            return true;
        }

        return false;
    }

    public Book postBook(Book book){
        bookList.add(book);
        return book;
    }

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
