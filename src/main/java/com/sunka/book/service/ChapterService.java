package com.sunka.book.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunka.book.entity.Chapter;
import com.sunka.book.model.ChapterModel;
import com.sunka.book.repo.BookRepository;
import com.sunka.book.repo.ChapterRepository;

@Service
public class ChapterService {
    @Autowired
    private ChapterRepository chapterRepository;
    
    @Autowired
    private BookRepository bookRepository;

    public List<Chapter> getChapters(Long bookId) {
        return chapterRepository.findAll()
                .stream()
                .filter(c -> c.getBook().getId().equals(bookId))
                .toList();
    }

    public Chapter getChapter(Long id) {
        return chapterRepository.findById(id).orElseThrow();
    }

    public Chapter createChapter(ChapterModel model) {
    	Chapter chapter = new Chapter();
    	chapter.setTitle(model.getTitle());
    	chapter.setBook(bookRepository.findById(model.getBookId()).orElse(null));
    	chapter.setCreatedAt(LocalDate.now());
    	
        return chapterRepository.save(chapter);
    }

    public Chapter updateChapter(Long id, ChapterModel updated) {
        Chapter chapter = getChapter(id);
        chapter.setTitle(updated.getTitle());
        return chapterRepository.save(chapter);
    }

    public void deleteChapter(Long id) {
        chapterRepository.deleteById(id);
    }
}

