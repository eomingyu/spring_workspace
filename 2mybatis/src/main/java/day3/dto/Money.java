package day3.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Money {
	private int custNo;
	private int saleNol;
	private int pcost;
	private int amount;
	private int price;
	private String pcode;
	private Date sdate;
	
}
