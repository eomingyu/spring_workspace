package com.idev.app.model;

import java.sql.Date;

public class Order {
	//model은 spring에서 데이터를 전달하는 목적으로 사용하는 객체입니다.
	//Order 클래스는 orderForm.jsp의 입력 데이터를 Controller의 order() 메소드에 전달하는 model 입니다.
	private String id;		//form 양식의 input 요소 name 속성과 동일하게 합니다.
	private int amount;
	private Date devDate;

	@Override
	public String toString() {
		return "Order [id=" + id + ", amount=" + amount + ", devDate=" + devDate + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDevDate() {
		return devDate;
	}

	public void setDevDate(Date devDate) {
		this.devDate = devDate;
	}
	
	

}
