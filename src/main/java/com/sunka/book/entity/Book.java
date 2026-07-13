package com.sunka.book.entity;

import java.time.LocalDate;
import java.util.List;

import com.sunka.book.enums.BookVisibility;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "title", nullable = false)
    private String title;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "visibility")
    private BookVisibility visibility; // public/private
    
    @Column(name = "views")
    private Integer views;
    
    @Column(name = "popularity")
    private Integer popularity;
    
    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "cover_link")
	private String coverLink;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Chapter> chapters;
    
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Rating> ratings;
    
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Favorite> favorites;

}
