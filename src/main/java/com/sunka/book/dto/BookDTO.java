package com.sunka.book.dto;

import java.time.LocalDate;

import com.sunka.book.enums.BookVisibility;

public record BookDTO(Long bookId, String title, BookVisibility visibility, int views, int popularity, LocalDate createdAt, String coverLink) {}

