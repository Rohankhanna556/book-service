package com.sunka.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunka.book.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {}
