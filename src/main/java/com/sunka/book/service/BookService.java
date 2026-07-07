package com.sunka.book.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunka.book.dto.BookDTO;
import com.sunka.book.entity.Book;
import com.sunka.book.mapper.BookMapper;
import com.sunka.book.model.BookModel;
import com.sunka.book.repo.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookMapper bookMapper;

	public List<BookDTO> getAllBooks() {
		
		List<BookDTO> bookDTOs = new ArrayList<BookDTO>();
		List<Book> books = bookRepository.findAll();
		for(Book book : books) {
			BookDTO bookDTO = bookMapper.toDTO(book);
			bookDTOs.add(bookDTO);
		}
		return bookDTOs;
	}

	public BookDTO getBook(Long id) {
		Book book = bookRepository.findById(id).orElseThrow();
		
        return bookMapper.toDTO(book);
	}

	public BookDTO createBook(BookModel model) {
		Book book = new Book();
		book.setTitle(model.getTitle());
		book.setCoverLink(model.getCoverLink());
		book.setPopularity(0);
		book.setViews(0);
		book.setVisibility(model.getVisibility());
		book.setCreatedAt(LocalDate.now());
		book = bookRepository.save(book);

		return bookMapper.toDTO(book);
	}

	public BookDTO updateBook(Long id, BookModel updated) {
		Book book = bookRepository.findById(id).orElseThrow();		
		book.setTitle(updated.getTitle());
		book.setVisibility(updated.getVisibility());
		book.setCoverLink(updated.getCoverLink());
		book = bookRepository.save(book);

		return bookMapper.toDTO(book);
	}

	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}
