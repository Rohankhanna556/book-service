package com.sunka.book.mapper;

import com.sunka.book.dto.ChapterDTO;
import com.sunka.book.entity.Chapter;

public class ChapterMapper {
    public ChapterDTO toDTO(Chapter chapter) {
        return new ChapterDTO(chapter.getId(), chapter.getTitle(), chapter.getCreatedAt());
    }
}

