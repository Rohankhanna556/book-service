package com.sunka.book.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunka.book.entity.Book;
import com.sunka.book.repo.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    public Book createBook(Book book) {
        book.setCreatedAt(LocalDate.now());
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updated) {
        Book book = getBook(id);
        book.setTitle(updated.getTitle());
        book.setVisibility(updated.getVisibility());
        book.setCover(updated.getCover());
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

