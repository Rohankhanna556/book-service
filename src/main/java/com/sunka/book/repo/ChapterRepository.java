package com.sunka.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunka.book.entity.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {}
