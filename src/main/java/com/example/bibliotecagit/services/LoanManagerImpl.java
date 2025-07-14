package com.example.bibliotecagit.services;

import com.example.bibliotecagit.entities.Book;
import com.example.bibliotecagit.exceptions.LibraryException;
import com.example.bibliotecagit.repository.BookRepository;

public class LoanManagerImpl implements LoanManager {
    private final BookRepository bookRepository;

    public LoanManagerImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void loanBook(String isbn) throws LibraryException {
        Book book = bookRepository.findBookByIsbn(isbn);
        if (!book.isAvailable()) {
            throw new LibraryException("El libro ya está prestado");
        }
        book.setAvailable(false);
    }

    @Override
    public void returnBook(String isbn) throws LibraryException {
        Book book = bookRepository.findBookByIsbn(isbn);
        if (book.isAvailable()) {
            throw new LibraryException("El libro ya está disponible en la biblioteca");
        }
        book.setAvailable(true);
    }
}
