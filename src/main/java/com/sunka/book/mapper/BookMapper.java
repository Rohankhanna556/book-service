package com.sunka.book.mapper;

import com.sunka.book.dto.BookDTO;
import com.sunka.book.entity.Book;

public class BookMapper {
    public static BookDTO toDTO(Book book) {
        return new BookDTO(book.getId(), book.getTitle(), book.getVisibility(),
                book.getViews(), book.getPopularity(), book.getCreatedAt(), book.getCover());
    }
}

