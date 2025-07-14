package com.example.bibliotecagit.services;

import com.example.bibliotecagit.exceptions.LibraryException;

public interface LoanManager {
    void loanBook(String isbn) throws LibraryException;

    void returnBook(String isbn) throws LibraryException;
}
