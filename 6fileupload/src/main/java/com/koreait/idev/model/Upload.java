package com.koreait.idev.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Upload {
	private String title;
	
	//MultipartFile 은 form 요소의 file 을 전달받아 참조합니다.
	private List<MultipartFile> pics;
	private List<MultipartFile> docs;
}
