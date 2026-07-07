package com.sunka.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunka.book.entity.Page;

public interface PageRepository extends JpaRepository<Page, Long> {}
