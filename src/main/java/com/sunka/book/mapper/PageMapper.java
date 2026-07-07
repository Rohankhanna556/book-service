package com.sunka.book.mapper;

import org.springframework.stereotype.Component;

import com.sunka.book.dto.PageDTO;
import com.sunka.book.entity.Page;

@Component
public class PageMapper {
    public PageDTO toDTO(Page page) {
        return new PageDTO(page.getId(), page.getImageUrl(), page.getSortOrder());
    }
}

