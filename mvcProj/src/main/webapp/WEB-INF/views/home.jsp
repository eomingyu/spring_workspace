<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>OUR BOOKCLUB</title>
    <link rel="stylesheet" href="resources/css/0_hrdkorea.css">
    <style>
        section{
            background-image: url(resources/image/main.jpg);
            background-repeat: no-repeat;
            background-position-x: center;
            background-size: 50%;
        }
    </style>
</head>
<body>
    <div class="wrap_container">
    <header>
            <h4 class="header-item">OUR BOOKCLUB 도서시스템 ver1.0</h4>
    </header>
    <nav>
    <c:set var="context" value="${pageContext.request.contextPath }"/>
        <ul class="container">
            <li><a href="#" >회원등록</a></li>
            <li><a href="#">회원목록조회/수정</a></li>
            <li><a href="#" >도서등록</a></li>
            <li><a href="${context }/book/list">도서목록조회/수정</a></li>
            <li><a href="${context }/book/rentList">대여조회</a></li>
            <li><a href="${context }/book/rent">도서대여</a></li>
            <li><a href="${context }/book/return">도서반납</a></li>
            <li><a href='${context }'>홈으로</a></li>
        </ul>
    </nav>
        <section style="padding-bottom: 300px;">
        </section>
    <footer>
        HRDKREA Copyright&copy2022 All rigths reserved. Human Resources Develpment Service of Korea;
   		<br><small>${serverTime }</small>
    </footer>
</div>
</body>
</html>