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
    <h4 style="text-align: center;">도서관 회원 등록</h4>
   <form action="" > 
       <!-- action 설정된 url로 입력요소에 작성된 데이터를 서버로 전송
            form 태그 속성 method="post" 있을때 와 없을때 차이점이 있습니다. -->
       <table style="width: 70%;margin:auto">
           <tr>
               <td class="col1_title">회원번호</td>
               <td><input type="text"name="num" placeholder="자동생성"></td> <!-- 입력요소 데이터 식별하는 속성은 name -->
           </tr>
           <tr>
            <td class="col1_title">회원성명</td>
            <td><input type="text"name="name" placeholder="성명 입력"></td>
            <!-- required="redquired 간단히 표현" -->
        </tr>
        <tr>
            <td class="col1_title">이메일</td>
            <td><input type="text"name="email" placeholder="이메일 입력" ></td>
        </tr>
        <tr>
            <td class="col1_title">회원전화</td>
            <td><input type="text"name="tel" placeholder="연락처 입력" ></td>
        </tr>
        <tr>
            <td class="col1_title">비밀번호</td>
            <td><input type="text"name="password" placeholder="비밀번호 입력"></td>
        </tr>
        
        <tr>
            <td colspan="2" style="text-align: center;">
                <button type="button" onclick="valid_check()">등록</button>
                <button onclick="location.href='5_memberList'">조회</button>
                <!-- button로 링크 또는 기능 설정하기
                onclick이벤트와 자바스크립트 명령을 이용
                location.href는 a태그의 href속성설정과 같은 내용 -->
                
                
            </td>
        </tr>
       </table>
   </form>
</section>
<script>
    //이름,이메일 필수입력
    function valid_check(){
        const frm = document.forms[0];
       const name_ = frm.name;  
       const email_ = frm.email;
       let isValid = true;
       

       if(name_.value == ""){
    alert('이름 입력은 필수입니다.')
    name_.focus();
    isValid=false;
} else
if(email_.value==""){
    alert('이메일 입력은 필수입니다.')
    email_.focus();
    isValid=false;
} else


if(isValid){
    alert('유효성 검사 통과!!')
                                   
}else
    alert('유효성 검사 실패!!')
    }
</script>
<footer>
    HRDKREA Copyright&copy2022 All rigths reserved. Human Resources Develpment Service of Korea;
</footer>
</body>
</html>