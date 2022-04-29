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
            <h4 style="text-align: center;">도서 대여 목록</h4>
            <table style ="width:85%; margin: auto;">
                <tr>   <!-- 첫번째 행, 제목행(가운데 정렬) -->
                   <th >대여번호</th>   
                   <th >회원번호</th>   
                   <th >도서코드</th>   
                   <th>대출일</th>
                   <th >반납예정일</th>
                   <th >반납일</th>
                   <th >연체일수</th>
                </tr>
               
               <c:forEach var="vo" items="${list }">
                <tr>
                   <td>${vo.rent_no }</td>
                   <td>${vo.mem_idx }</td>
                   <td>${vo.bcode }</td>
                   <td>${vo.rent_date }</td>
                   <td>${vo.exp_date }</td>
                   <td>${vo.return_date }</td>
                   <td>${vo.delay_days }</td>
                </tr>
               </c:forEach>
               
            </table>
        </section>
    <footer>
        HRDKREA Copyright&copy2022 All rigths reserved. Human Resources Develpment Service of Korea;
    </footer>
</body>
</html>