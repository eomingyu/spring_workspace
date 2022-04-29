<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <h4 style="text-align: center;">도서 목록 조회/수정</h4>
            <table style ="width:85%; margin: auto;">
                <tr>   <!-- 첫번째 행, 제목행(가운데 정렬) -->
                   <th >도서코드</th>   <!-- 4개의 칸(열) -->
                   <th>제목</th>
                   <th >저자</th>
                   <th >출판사</th>
                   <th >출판일</th>
                </tr>
               
               <c:forEach var="vo" items="${list }">
                <tr>
                   <td>${vo.bcode }</td>
                   <td class="name">${vo.title }</td>
                   <td>${vo.writer }</td>
                   <td>${vo.publisher }</td>
                   <td>${vo.pdate }</td>
                </tr>
               </c:forEach>
               
            </table>
        </section>
    <footer>
        HRDKREA Copyright&copy2022 All rigths reserved. Human Resources Develpment Service of Korea;
    </footer>
</body>
</html>