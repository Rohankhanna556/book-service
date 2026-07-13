package com.sunka.book.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunka.book.entity.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    Optional<Favorite> findByBookIdAndUsername(Long bookId, String username);
    List<Favorite> findByUsername(String username);
	List<Favorite> findByBookId(Long bookId);
}
