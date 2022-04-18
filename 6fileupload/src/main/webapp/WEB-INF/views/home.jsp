<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
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
<a href="upload">첫번째 업로드-이미지</a><br>
<a href="gallery">gallery 테이블</a><br>
<a href="upload2">두번째 업로드-pdf 파일</a><br>
</body>
</html>
