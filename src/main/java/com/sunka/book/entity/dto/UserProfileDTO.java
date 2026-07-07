package com.sunka.book.entity.dto;

import java.time.LocalDate;

public record UserProfileDTO(Long userId, String username, String email, LocalDate createdAt) {}

