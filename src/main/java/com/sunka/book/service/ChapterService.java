package com.sunka.book.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunka.book.dto.ChapterDTO;
import com.sunka.book.entity.Chapter;
import com.sunka.book.mapper.ChapterMapper;
import com.sunka.book.model.ChapterModel;
import com.sunka.book.repo.BookRepository;
import com.sunka.book.repo.ChapterRepository;

@Service
public class ChapterService {
    @Autowired
    private ChapterRepository chapterRepository;
    
    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private ChapterMapper chapterMapper;

    public List<ChapterDTO> getChapters(Long bookId) {

        List<ChapterDTO> chapterDTOs = new ArrayList<ChapterDTO>();
		List<Chapter> chapters = chapterRepository.findAll()
                .stream()
                .filter(c -> c.getBook().getId().equals(bookId))
                .toList();
		for(Chapter chapter : chapters) {
			ChapterDTO chapterDTO = chapterMapper.toDTO(chapter);
			chapterDTOs.add(chapterDTO);
		}
		return chapterDTOs;
    }

    public ChapterDTO getChapter(Long id) {
        Chapter chapter = chapterRepository.findById(id).orElseThrow();
        return chapterMapper.toDTO(chapter);
    }

    public ChapterDTO createChapter(ChapterModel model) {
    	Chapter chapter = new Chapter();
    	chapter.setTitle(model.getTitle());
    	chapter.setBook(bookRepository.findById(model.getBookId()).orElse(null));
    	chapter.setCreatedAt(LocalDate.now());
    	
    	chapter = chapterRepository.save(chapter);
        return chapterMapper.toDTO(chapter);
    }

    public ChapterDTO updateChapter(Long id, ChapterModel updated) {
        Chapter chapter = chapterRepository.findById(id).orElseThrow();
        chapter.setTitle(updated.getTitle());
        chapter =  chapterRepository.save(chapter);
        return chapterMapper.toDTO(chapter);
    }

    public void deleteChapter(Long id) {
        chapterRepository.deleteById(id);
    }
}

