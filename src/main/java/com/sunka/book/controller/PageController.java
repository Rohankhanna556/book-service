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

import com.sunka.book.dto.PageDTO;
import com.sunka.book.model.PageModel;
import com.sunka.book.service.PageService;

@RestController
@RequestMapping("/api/pages")
public class PageController {
    @Autowired
    private PageService pageService;

    @GetMapping
    public List<PageDTO> getPages(@RequestParam("chapterId") Long chapterId) {
        return pageService.getPages(chapterId);
    }

    @GetMapping("/{pageId}")
    public PageDTO getPage(@PathVariable Long pageId) {
        return pageService.getPage(pageId);
    }

    @PostMapping
    public PageDTO createPage(@RequestBody PageModel page) {
        return pageService.createPage(page);
    }

    @PutMapping("/{pageId}")
    public PageDTO updatePage(@PathVariable Long pageId, @RequestBody PageModel page) {
        return pageService.updatePage(pageId, page);
    }

    @DeleteMapping("/{pageId}")
    public void deletePage(@PathVariable Long pageId) {
        pageService.deletePage(pageId);
    }
}
