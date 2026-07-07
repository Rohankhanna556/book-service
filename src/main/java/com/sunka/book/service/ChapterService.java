package com.sunka.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunka.book.entity.Chapter;
import com.sunka.book.repo.ChapterRepository;

@Service
public class ChapterService {
    @Autowired
    private ChapterRepository chapterRepository;

    public List<Chapter> getChapters(Long bookId) {
        return chapterRepository.findAll()
                .stream()
                .filter(c -> c.getBook().getId().equals(bookId))
                .toList();
    }

    public Chapter getChapter(Long id) {
        return chapterRepository.findById(id).orElseThrow();
    }

    public Chapter createChapter(Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    public Chapter updateChapter(Long id, Chapter updated) {
        Chapter chapter = getChapter(id);
        chapter.setTitle(updated.getTitle());
        chapter.setPdfUrl(updated.getPdfUrl());
        return chapterRepository.save(chapter);
    }

    public void deleteChapter(Long id) {
        chapterRepository.deleteById(id);
    }
}

