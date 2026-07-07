package com.sunka.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunka.book.dto.ChapterDTO;
import com.sunka.book.model.ChapterModel;
import com.sunka.book.service.ChapterService;

@RestController
@RequestMapping("/api/chapters")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @GetMapping
    public List<ChapterDTO> getChapters(@RequestParam("bookId") Long bookId) {
        return chapterService.getChapters(bookId);
    }

    @GetMapping("/{chapterId}")
    public ChapterDTO getChapter(@PathVariable Long chapterId) {
        return chapterService.getChapter(chapterId);
    }

    @PostMapping
    public ChapterDTO createChapter(@RequestBody ChapterModel chapter) {
        return chapterService.createChapter(chapter);
    }

    @PutMapping("/{chapterId}")
    public ChapterDTO updateChapter(@PathVariable Long chapterId, @RequestBody ChapterModel chapter) {
        return chapterService.updateChapter(chapterId, chapter);
    }

    @DeleteMapping("/{chapterId}")
    public void deleteChapter(@PathVariable Long chapterId) {
        chapterService.deleteChapter(chapterId);
    }
}
