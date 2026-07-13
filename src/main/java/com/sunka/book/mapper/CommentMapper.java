package com.sunka.book.mapper;

import org.springframework.stereotype.Component;

import com.sunka.book.dto.CommentDTO;
import com.sunka.book.entity.Comment;

@Component
public class CommentMapper {
	public CommentDTO toDTO(Comment comment) {
		CommentDTO dto = new CommentDTO();
		dto.setBookId(comment.getBook().getId());
		dto.setId(comment.getId());
		dto.setChapterId(comment.getChapter().getId());
		dto.setCommentBy(comment.getCommentBy());
		dto.setCreatedAt(comment.getCreatedAt());
		dto.setText(comment.getText());
		return dto;
	}

}
