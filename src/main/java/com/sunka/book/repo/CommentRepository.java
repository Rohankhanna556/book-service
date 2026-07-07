package com.sunka.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunka.book.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {}
