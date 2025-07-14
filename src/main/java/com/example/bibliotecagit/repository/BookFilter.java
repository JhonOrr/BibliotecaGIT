package com.example.bibliotecagit.repository;

import com.example.bibliotecagit.entities.Book;

public interface BookFilter {
  boolean filter(Book book);
}