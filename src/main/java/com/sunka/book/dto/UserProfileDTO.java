package com.sunka.book.dto;

import java.time.LocalDate;

public record UserProfileDTO(Long userId, String username, String email, LocalDate createdAt) {}

