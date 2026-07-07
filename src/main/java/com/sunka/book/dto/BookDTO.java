package com.sunka.book.dto;

import java.time.LocalDate;

public record BookDTO(Long bookId, String title, String visibility, int views, int popularity, LocalDate createdAt, String cover) {}

