package com.sunka.book.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PageModel {

	private String imageUrl;

	private Integer sortOrder;

	private Long chapterId;
}
