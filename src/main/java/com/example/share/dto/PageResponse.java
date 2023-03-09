package com.example.share.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageResponse<T> {
	
	private List<T> content;
	private Integer currentPage;
	private Long totalElements;
	private Integer totalPages;
	
}
