package com.mycompany.idev.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comments {
	private int idx;
	private int mref;
	private String name;
	private String content;
	private Timestamp wdate;	//LocalDateTime
	private String ip;
	private int heart;
}
