package com.koreait.idev.model;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gallery {
		private int pno;
		private String title;
		private String filenames;	//업로드한 파일명을 ,로 구분해서 나열하고 저장 
		private Timestamp wdate;
		
	
	//MultipartFile 은 form 요소의 file 을 전달받아 참조합니다.//db저장 X
	private List<MultipartFile> pics;
}
/*
CREATE TABLE gallery( 
pno number(5) NOT NULL, 
title varchar2(40), 
wdate DATE,
filenames varchar2(70), --업로드 후 파일명 저장 컬럼 
PRIMARY KEY(pno) );

CREATE SEQUENCE pno_seq;
*/

