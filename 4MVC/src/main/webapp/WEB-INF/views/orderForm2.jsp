<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>orderForm2</title>
</head>
<body>
	<h3>사용자 입력 폼</h3>
	<form action="orderAttr" method="post">
		<input name="id" placeholder="주문 ID">
		<input name="amount"  type="number"  
		  placeholder="주문 수량">
		배송날짜 : <input name="devDate" type="date">
		<input type="submit" value="주문">
	</form>
</body>
</html>