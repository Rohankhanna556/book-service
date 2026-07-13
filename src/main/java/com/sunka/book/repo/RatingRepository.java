package com.sunka.book.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunka.book.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {

	List<Rating> findByBookId(Long bookId);

	int countByBookId(Long id);}
