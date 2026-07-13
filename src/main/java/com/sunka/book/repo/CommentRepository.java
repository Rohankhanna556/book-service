package com.sunka.book.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunka.book.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByChapterId(Long chapterId);

	List<Comment> findByBookId(Long bookId);}
