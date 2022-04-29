package com.idev.bookrent.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
	
	private String bcode;
	private String title;
	private String writer;
	private String publisher;
	private Date pdate;
}
