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
            <h4 style="text-align: center;">도서반납</h4>
       <form action="" > 
           <!-- action 설정된 url로 입력요소에 작성된 데이터를 서버로 전송
                form 태그 속성 method="post" 있을때 와 없을때 차이점이 있습니다. -->
           <table style="width: 70%;margin:auto">
               <tr>
                   <td class="col1_title">대여NO</td>
                   <td><input type="text"name="rentno"size="17" placeholder="대여NO입력"></td> <!-- 입력요소 데이터 식별하는 속성은 name -->
               </tr>
               <tr>
                <td class="col1_title">회원번호</td>
                <td><input type="text"name="idno" size="17" placeholder="회원번호 입력"></td>
                <!-- required="redquired 간단히 표현" -->
            </tr>
            <tr>
                <td class="col1_title">도서코드</td>
                <td><input type="text"name="bookno" size="17" placeholder="도서코드 입력">
                    <input type="button" value="조회" onclick="valid_check()" ></td>
            </tr>
            <tr>
                <td class="col1_title">대여일자</td>
                <td><input type="date"name="rent_date" id="rent_date"></td>
            </tr>
            <tr>
                <td class="col1_title">반납일자</td>
                <td><input type="date"name="return_date" id="return_date">
                    <input type="button" value="반납" onclick="valid_check()"
                    style="margin-left: 6px;" ></td>
            </tr>
           </table>
       </form>
        </section>
    <footer>
        HRDKREA Copyright&copy2022 All rigths reserved. Human Resources Develpment Service of Korea;
    </footer>
</body>
</html>