package com.sunka.book.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ChapterModel {

	private String title;
	private Long bookId;
}
