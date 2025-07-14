package com.biblioteca.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.biblioteca.entities.Book;
import com.biblioteca.exceptions.LibraryException;
import com.biblioteca.repository.BookRepository;

public class ArrayListBookRepository implements BookRepository {
  private List<Book> books = new ArrayList<>();

  @Override
  public void addBook(Book book) throws LibraryException {
    if (book == null) {
      throw new LibraryException("El libro no puede ser nulo");
    }
    for (Book b : books) {
      if (b.getIsbn().equals(book.getIsbn())) {
        throw new LibraryException("ISBN duplicado: " + book.getIsbn());
      }
    }
    books.add(book);
  }

  @Override
  public void removeBook(String isbn) throws LibraryException {
    Book toRemove = findBookByIsbn(isbn);
    books.remove(toRemove);
  }

  @Override
  public Book findBookByIsbn(String isbn) throws LibraryException {
    for (Book b : books) {
      if (b.getIsbn().equals(isbn)) {
        return b;
      }
    }
    throw new LibraryException("Libro no encontrado con ISBN: " + isbn);
  }

  @Override
  public List<Book> getAllBooks() {
    return new ArrayList<>(books);
  }
}