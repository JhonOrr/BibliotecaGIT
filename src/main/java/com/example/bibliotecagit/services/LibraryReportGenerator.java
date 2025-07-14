package com.example.bibliotecagit.services;

import java.util.List;

import com.example.bibliotecagit.entities.Book;
import com.example.bibliotecagit.repository.BookRepository;
import com.example.bibliotecagit.repository.BookFilter;

public class LibraryReportGenerator {
    private final BookRepository bookRepository;

    public LibraryReportGenerator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooksByFilter(BookFilter filter) {
        return bookRepository.filterBooks(filter);
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.getBooksByAuthor(author);
    }

    public List<Book> getAvailableBooks() {
        return bookRepository.filterBooks(Book::isAvailable);
    }
}
