package com.sunka.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunka.book.entity.Page;
import com.sunka.book.repo.PageRepository;

@Service
public class PageService {
    @Autowired
    private PageRepository pageRepository;

    public List<Page> getPages(Long chapterId) {
        return pageRepository.findAll()
                .stream()
                .filter(p -> p.getChapter().getChapterId().equals(chapterId))
                .toList();
    }

    public Page getPage(Long id) {
        return pageRepository.findById(id).orElseThrow();
    }

    public Page createPage(Page page) {
        return pageRepository.save(page);
    }

    public Page updatePage(Long id, Page updated) {
        Page page = getPage(id);
        page.setImageUrl(updated.getImageUrl());
        page.setOrientation(updated.getOrientation());
        return pageRepository.save(page);
    }

    public void deletePage(Long id) {
        pageRepository.deleteById(id);
    }
}
	