package com.biblioteca.repository;

import com.biblioteca.entities.Book;

public interface BookFilter {
  boolean filter(Book book);
}