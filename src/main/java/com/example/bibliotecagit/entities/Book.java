package com.example.bibliotecagit.entities;

import com.example.bibliotecagit.exceptions.LibraryException;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private boolean available;

    public Book(String isbn, String title, String author, int publicationYear) throws LibraryException {
        setIsbn(isbn);
        setTitle(title);
        setAuthor(author);
        setPublicationYear(publicationYear);
        this.available = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) throws LibraryException {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new LibraryException("ISBN debe contener algo");
        }
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws LibraryException {
        if (title == null || title.trim().isEmpty()) {
            throw new LibraryException("El no debe estar vacio");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws LibraryException {
        if (author == null || author.trim().isEmpty()) {
            throw new LibraryException("El autor no puede estar vacío");
        }
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) throws LibraryException {
        if (publicationYear < 0) {
            throw new LibraryException("El año de publicación no puede ser negativo");
        }
        this.publicationYear = publicationYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
