package com.sunka.book.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunka.book.dto.BookDTO;
import com.sunka.book.dto.CommentDTO;
import com.sunka.book.dto.RatingDTO;
import com.sunka.book.model.BookModel;
import com.sunka.book.model.CommentModel;
import com.sunka.book.model.RatingModel;
import com.sunka.book.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    // ✅ Readers can view
    @GetMapping
    public List<BookDTO> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookDTO getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    // ✅ Admins manage
    @PostMapping
    public BookDTO createBook(@RequestBody BookModel book) {
        return bookService.createBook(book);
    }

    @PutMapping("/{id}")
    public BookDTO updateBook(@PathVariable Long id, @RequestBody BookModel book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    // ✅ Readers can add ratings/comments
    @PostMapping("/{bookId}/ratings")
    public RatingDTO addRating(@PathVariable Long bookId, @RequestBody RatingModel rating) {
        return bookService.addRating(bookId, rating);
    }

    @GetMapping("/{bookId}/ratings")
    public List<RatingDTO> getRatings(@PathVariable Long bookId) {
        return bookService.getRatings(bookId);
    }

    @PostMapping("/{bookId}/comments")
    public CommentDTO addBookComment(@PathVariable Long bookId, @RequestBody CommentModel comment) {
        return bookService.addBookComment(bookId, comment);
    }

    @GetMapping("/{bookId}/comments")
    public List<CommentDTO> getBookComments(@PathVariable Long bookId) {
        return bookService.getBookComments(bookId);
    }
    
    @PostMapping("/{bookId}/favorites")
    public void addFavorite(@PathVariable Long bookId, Principal principal) {
        if (principal == null) {
            throw new RuntimeException("Authentication required to add favorite");
        }
        bookService.addFavorite(bookId, principal.getName());
    }

    // Remove favorite (authenticated only)
    @DeleteMapping("/{bookId}/favorites")
    public void removeFavorite(@PathVariable Long bookId, Principal principal) {
        if (principal == null) {
            throw new RuntimeException("Authentication required to remove favorite");
        }
        bookService.removeFavorite(bookId, principal.getName());
    }

    // Get all favorites for this book (public)
    @GetMapping("/{bookId}/favorites")
    public List<String> getFavorites(@PathVariable Long bookId) {
        return bookService.getFavorites(bookId);
    }

}
