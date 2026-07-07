package com.sunka.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunka.book.entity.Page;
import com.sunka.book.model.PageModel;
import com.sunka.book.repo.ChapterRepository;
import com.sunka.book.repo.PageRepository;

@Service
public class PageService {
    @Autowired
    private PageRepository pageRepository;
    
    @Autowired
    private ChapterRepository chapterRepository;

    public List<Page> getPages(Long chapterId) {
        return pageRepository.findAll()
                .stream()
                .filter(p -> p.getChapter().getId().equals(chapterId))
                .toList();
    }

    public Page getPage(Long id) {
        return pageRepository.findById(id).orElseThrow();
    }

    public Page createPage(PageModel model) {
    	Page page = new Page();
    	page.setChapter(chapterRepository.findById(model.getChapterId()).orElse(null));
    	page.setImageUrl(model.getImageUrl());
    	page.setSortOrder(model.getSortOrder());
        return pageRepository.save(page);
    }

    public Page updatePage(Long id, PageModel updated) {
        Page page = getPage(id);
        page.setImageUrl(updated.getImageUrl());
        page.setSortOrder(updated.getSortOrder());
        return pageRepository.save(page);
    }

    public void deletePage(Long id) {
        pageRepository.deleteById(id);
    }
}
	