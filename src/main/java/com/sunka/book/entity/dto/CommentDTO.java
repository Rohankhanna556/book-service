package com.sunka.book.entity.dto;

import java.time.LocalDateTime;

public record CommentDTO(Long id, String user, String text, LocalDateTime createdAt) {}

