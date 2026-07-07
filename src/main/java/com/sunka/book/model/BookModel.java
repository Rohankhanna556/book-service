package com.sunka.book.model;

import com.sunka.book.enums.BookVisibility;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BookModel {

	private String title;

	private BookVisibility visibility; // public/private

	private Integer views;

	private Integer popularity;

	private String coverLink;
}
