package com.sunka.book.mapper;

import org.springframework.stereotype.Component;

import com.sunka.book.dto.BookDTO;
import com.sunka.book.entity.Book;

@Component
public class BookMapper {
    public BookDTO toDTO(Book book) {
        return new BookDTO(book.getId(), book.getTitle(), book.getVisibility(),
                book.getViews(), book.getPopularity(), book.getCreatedAt(), book.getCoverLink());
    }
}

