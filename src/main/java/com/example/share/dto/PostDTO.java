package com.example.share.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
	
	private String text;
	
    private byte[] image;
	
	private List<LikesDTO> likes;
	
}
