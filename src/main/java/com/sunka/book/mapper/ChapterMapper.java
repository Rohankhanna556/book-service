package com.sunka.book.mapper;

import org.springframework.stereotype.Component;

import com.sunka.book.dto.ChapterDTO;
import com.sunka.book.entity.Chapter;

@Component
public class ChapterMapper {
    public ChapterDTO toDTO(Chapter chapter) {
        return new ChapterDTO(chapter.getId(), chapter.getTitle(), chapter.getCreatedAt());
    }
}

