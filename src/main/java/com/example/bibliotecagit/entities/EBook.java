package com.example.bibliotecagit.entities;

import com.example.bibliotecagit.exceptions.LibraryException;

public class EBook extends Book{
   private String format;

  public EBook(String isbn, String title, String author, int publicationYear, String format) throws LibraryException {
    super(isbn, title, author, publicationYear);
    setFormat(format);
  }

  public String getFormat() {
    return format;
  }

  public void setFormat(String format) throws LibraryException {
    if (format == null || format.trim().isEmpty()) {
      throw new LibraryException("El formato no puede estar vacío");
    }
    this.format = format;
  }
}
