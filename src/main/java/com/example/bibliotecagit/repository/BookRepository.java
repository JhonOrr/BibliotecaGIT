package com.biblioteca.repository;

import java.util.List;

import com.biblioteca.entities.Book;
import com.biblioteca.exceptions.LibraryException;

import java.util.ArrayList;

public interface BookRepository {
  void addBook(Book book) throws LibraryException;

  void removeBook(String isbn) throws LibraryException;

  Book findBookByIsbn(String isbn) throws LibraryException;

  List<Book> getAllBooks();

  default List<Book> filterBooks(BookFilter filter) {
    List<Book> result = new ArrayList<>();
    for (Book book : getAllBooks()) {
      if (filter.filter(book)) {
        result.add(book);
      }
    }
    return result;
  }

  default List<Book> getBooksByAuthor(String author) {
    return getAllBooks().stream()
        .filter(b -> b.getAuthor().equalsIgnoreCase(author))
        .toList();
  }
}