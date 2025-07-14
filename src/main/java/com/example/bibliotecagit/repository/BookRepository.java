package com.example.bibliotecagit.repository;

import java.util.List;
import java.util.ArrayList;

import com.example.bibliotecagit.entities.Book;
import com.example.bibliotecagit.exceptions.LibraryException;

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