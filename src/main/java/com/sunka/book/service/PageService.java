package com.sunka.book.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunka.book.dto.PageDTO;
import com.sunka.book.entity.Page;
import com.sunka.book.mapper.PageMapper;
import com.sunka.book.model.PageModel;
import com.sunka.book.repo.ChapterRepository;
import com.sunka.book.repo.PageRepository;

@Service
public class PageService {
    @Autowired
    private PageRepository pageRepository;
    
    @Autowired
    private ChapterRepository chapterRepository;
    
    @Autowired
    private PageMapper pageMapper;

    public List<PageDTO> getPages(Long chapterId) {
        
        List<PageDTO> pageDTOs = new ArrayList<PageDTO>();
		List<Page> pages = pageRepository.findAll()
                .stream()
                .filter(p -> p.getChapter().getId().equals(chapterId))
                .toList();
        
		for(Page page : pages) {
			PageDTO pageDTO = pageMapper.toDTO(page);
			pageDTOs.add(pageDTO);
		}
		return pageDTOs;
    }

    public PageDTO getPage(Long id) {
    	Page page = pageRepository.findById(id).orElseThrow();
    	return pageMapper.toDTO(page);
    }

    public PageDTO createPage(PageModel model) {
    	Page page = new Page();
    	page.setChapter(chapterRepository.findById(model.getChapterId()).orElse(null));
    	page.setImageUrl(model.getImageUrl());
    	page.setSortOrder(model.getSortOrder());
    	page = pageRepository.save(page);
    	return pageMapper.toDTO(page);
    }

    public PageDTO updatePage(Long id, PageModel updated) {
    	Page page = pageRepository.findById(id).orElseThrow();
        page.setImageUrl(updated.getImageUrl());
        page.setSortOrder(updated.getSortOrder());
        page = pageRepository.save(page);
    	return pageMapper.toDTO(page);
    }

    public void deletePage(Long id) {
        pageRepository.deleteById(id);
    }
}
	