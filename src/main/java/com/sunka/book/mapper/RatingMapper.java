package com.sunka.book.mapper;

import org.springframework.stereotype.Component;

import com.sunka.book.dto.RatingDTO;
import com.sunka.book.entity.Rating;

@Component
public class RatingMapper {
    public RatingDTO toDTO(Rating rating) {
    	RatingDTO dto = new RatingDTO();
    	dto.setBookId(rating.getBook().getId());
    	dto.setId(rating.getId());
    	dto.setRatedBy(rating.getRatedBy());
    	dto.setScore(rating.getScore());
    	return dto;
    }
}

