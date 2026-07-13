package com.sunka.book.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunka.book.dto.BookDTO;
import com.sunka.book.dto.CommentDTO;
import com.sunka.book.dto.RatingDTO;
import com.sunka.book.entity.Book;
import com.sunka.book.entity.Comment;
import com.sunka.book.entity.Favorite;
import com.sunka.book.entity.Rating;
import com.sunka.book.mapper.BookMapper;
import com.sunka.book.mapper.CommentMapper;
import com.sunka.book.mapper.RatingMapper;
import com.sunka.book.model.BookModel;
import com.sunka.book.model.CommentModel;
import com.sunka.book.model.RatingModel;
import com.sunka.book.repo.BookRepository;
import com.sunka.book.repo.CommentRepository;
import com.sunka.book.repo.FavoriteRepository;
import com.sunka.book.repo.RatingRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookMapper bookMapper;
	
	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private RatingMapper ratingMapper;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private FavoriteRepository favoriteRepository;

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

        // Increment views when book is fetched
        book.setViews(book.getViews() == null ? 1 : book.getViews() + 1);

        // Update popularity after increment
        updatePopularity(book);

        return bookMapper.toDTO(book);
    }

	// ✅ Popularity calculation
    public void updatePopularity(Book book) {
        int ratingCount = ratingRepository.countByBookId(book.getId());
        int views = book.getViews() == null ? 0 : book.getViews();
        book.setPopularity(views + ratingCount);
        bookRepository.save(book);
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
	
	public RatingDTO addRating(Long bookId, RatingModel rating) {
	    Book book = bookRepository.findById(bookId).orElseThrow();
	    Rating entity = Rating.builder()
	        .ratedBy(rating.getRatedBy())
	        .score(rating.getScore())
	        .book(book)
	        .build();
	    ratingRepository.save(entity);
	    
	    // Update popularity after new rating
        updatePopularity(book);
	    return ratingMapper.toDTO(entity);
	}

	public List<RatingDTO> getRatings(Long bookId) {
	    return ratingRepository.findByBookId(bookId).stream()
	        .map(ratingMapper::toDTO)
	        .toList();
	}

	public CommentDTO addBookComment(Long bookId, CommentModel comment) {
	    Book book = bookRepository.findById(bookId).orElseThrow();
	    Comment entity = Comment.builder()
	        .commentBy(comment.getCommentBy())
	        .text(comment.getText())
	        .createdAt(LocalDateTime.now())
	        .book(book)
	        .build();
	    commentRepository.save(entity);
	    return commentMapper.toDTO(entity);
	}

	public List<CommentDTO> getBookComments(Long bookId) {
	    return commentRepository.findByBookId(bookId).stream()
	        .map(commentMapper::toDTO)
	        .toList();
	}

	public void addFavorite(Long bookId, String username) {
        if (favoriteRepository.findByBookIdAndUsername(bookId, username).isEmpty()) {
            Book book = bookRepository.findById(bookId).orElseThrow();
            Favorite fav = Favorite.builder()
                                   .book(book)
                                   .username(username)
                                   .build();
            favoriteRepository.save(fav);
        }
    }

    public void removeFavorite(Long bookId, String username) {
        favoriteRepository.findByBookIdAndUsername(bookId, username)
            .ifPresent(favoriteRepository::delete);
    }

    // Return all usernames who favorited this book
    public List<String> getFavorites(Long bookId) {
        return favoriteRepository.findByBookId(bookId)
                                 .stream()
                                 .map(Favorite::getUsername)
                                 .toList();
    }

}
