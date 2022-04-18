<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> 지우기 세션 못씀--%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<hr>
<a href="community/list">우리동네 커뮤니티</a>
<h3>일반 사용자 : 고객님.</h3>
<c:if test="${user!=null}"><!-- 로그인 했을 때 메뉴 -->
<a href="logout">로그아웃</a>
<br>${sessionScope.user.name }님 환영합니다.
</c:if>
<c:if test="${user==null}"><!-- 로그인 안 했을 때 메뉴 -->
<a href="login">고객님 로그인</a>
</c:if>
<hr>
<!-- 관리자 메뉴 : 나중에 별도로 페이지를 만듭니다. -->
<h3>관리자</h3>
<c:if test="${admin!=null}"><!-- 관리자 로그인 했을 때 메뉴 -->
<a href="logout">로그아웃</a>
<br>${admin.adminId }님 환영합니다.

</c:if>
<c:if test="${admin==null}">
<a href="admin">관리자 로그인</a>

</c:if>
</body>
</html>
