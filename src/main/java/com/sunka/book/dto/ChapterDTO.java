package com.sunka.book.dto;

import java.time.LocalDate;

public record ChapterDTO(Long chapterId, String title, LocalDate createdAt) {}

