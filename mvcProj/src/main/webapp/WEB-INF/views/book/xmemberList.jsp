<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>OUR BOOKCLUB</title>
    <link rel="stylesheet" href="../resources/css/0_hrdkorea.css">
</head>
<body>
	<header>
		<h4 class="header-item">도서대여 시스템 ver1.0</h4>
	</header>
	<nav>
	<c:set var="context" value="${pageContext.request.contextPath }"/>
		<ul class="container">
			<li><a href="#">회원등록</a></li>
			<li><a href="#">회원목록조회/수정</a></li>
			<li><a href="#">도서등록</a></li>
			<li><a href="${context }/book/list">도서목록조회/수정</a></li>
            <li><a href="${context }/book/rentList">대여조회</a></li>
            <li><a href="${context }/book/rent">도서대여</a></li>
            <li><a href="${context }/book/return">도서반납</a></li>
			<li><a href='${context }'>홈으로</a></li>
		</ul>
	</nav>


	<section style="padding-bottom: 300px;">
		<h4 style="text-align: center;">회원 목록 조회/수정</h4>
		<table style="width: 85%; margin: auto;">
			<caption>&lt;2022년 3월 1일 기준&gt;</caption>
			<!-- 테이블 제목 -->
			<tr>
				<!-- 첫번째 행, 제목행(가운데 정렬) -->
				<th>회원번호</th>
				<!-- 4개의 칸(열) -->
				<th>이름</th>
				<th>이메일</th>
				<th>회원전화</th>
				<th>비밀번호</th>
			</tr>
			<tr>
				<td>1</td>
				<td class="name">홍길동</td>
				<td>abc123@naver.com</td>
				<td>010-1234-5511</td>
				<td>1111</td>

			</tr>
			<tr>
				<td>2</td>
				<td class="name">김모모</td>
				<td>abb232@daum.net</td>
				<td>010-3333-4444</td>
				<td>2222</td>

			</tr>
			<tr>
				<td>3</td>
				<td class="name">최나나</td>
				<td>sss@gmail.com</td>
				<td>010-5555-6666</td>
				<td>3333</td>

			</tr>
		</table>
	</section>
	<footer> HRDKREA Copyright&copy2022 All rigths reserved. Human
		Resources Develpment Service of Korea; </footer>
</body>
</html>