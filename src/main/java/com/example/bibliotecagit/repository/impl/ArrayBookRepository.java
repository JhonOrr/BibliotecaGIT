package com.example.bibliotecagit.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.bibliotecagit.entities.Book;
import com.example.bibliotecagit.exceptions.LibraryException;
import com.example.bibliotecagit.repository.BookRepository;

public class ArrayBookRepository implements BookRepository {
  private static final int MAX_SIZE = 100;
  private Book[] books = new Book[MAX_SIZE];
  private int count = 0;

  @Override
  public void addBook(Book book) throws LibraryException {
    if (book == null) {
      throw new LibraryException("El libro no puede ser nulo");
    }
    if (count >= MAX_SIZE) {
      throw new LibraryException("Repositorio lleno");
    }
    for (int i = 0; i < count; i++) {
      if (books[i].getIsbn().equals(book.getIsbn())) {
        throw new LibraryException("ISBN duplicado: " + book.getIsbn());
      }
    }
    books[count++] = book;
  }

  @Override
  public void removeBook(String isbn) throws LibraryException {
    int index = -1;
    for (int i = 0; i < count; i++) {
      if (books[i].getIsbn().equals(isbn)) {
        index = i;
        break;
      }
    }
    if (index == -1) {
      throw new LibraryException("Libro no encontrado con ISBN: " + isbn);
    }
    for (int i = index; i < count - 1; i++) {
      books[i] = books[i + 1];
    }
    books[--count] = null;
  }

  @Override
  public Book findBookByIsbn(String isbn) throws LibraryException {
    for (int i = 0; i < count; i++) {
      if (books[i].getIsbn().equals(isbn)) {
        return books[i];
      }
    }
    throw new LibraryException("Libro no encontrado con ISBN: " + isbn);
  }

  @Override
  public List<Book> getAllBooks() {
    List<Book> list = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      list.add(books[i]);
    }
    return list;
  }
}