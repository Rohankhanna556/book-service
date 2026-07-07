package com.sunka.book.mapper;

import com.sunka.book.entity.Book;
import com.sunka.book.entity.dto.BookDTO;

public class BookMapper {
    public static BookDTO toDTO(Book book) {
        return new BookDTO(book.getBookId(), book.getTitle(), book.getVisibility(),
                book.getViews(), book.getPopularity(), book.getCreatedAt(), book.getCover());
    }
}

