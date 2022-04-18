<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드 테스트</title>
<style type="text/css">
/*  div {
 	width: 400px;
	height: 400px;
	padding: 50px;
	margin: 100px auto;
	border: 1px solid gray;
} */
</style>
<link href="${pageContext.request.contextPath }/resources/css/gallery.css" rel="stylesheet">
</head>
<body>
	<h3>파일업로드 테스트</h3>
	<hr>
	<!-- MIME 타입 : multipart/form-data , image/* , application/pdf 등
		웹에서 사용하는 파일의 종류(일반적으로 알고 있는 확장자)
 -->
	<form action="gallery" method="post" enctype="multipart/form-data">
		<input type="text" placeholder="제목입력하세요." name="title"><br>
		이미지 파일을 선택하세요.(최대 3개)<br> 
		<input type="file" name="pics"
			accept="image/*"><br> 
		<input type="file" name="pics"
			accept="image/*"><br> 
		<input type="file" name="pics"
			accept="image/*"><br>
		<button>전송</button>
	</form>
	<hr>
	<c:forEach items="${list }" var="vo" varStatus="main">
	<div class="slideshow-container">

		<div id="item${main.count }">
		<c:forEach items="${vo.filenames }" var="pic" varStatus="stat">
			<!-- 업로드한 3개의 파일명을 리스트로 애트리뷰트에서 가져오기 -->
			<div class="mySlides fade">
				<div class="numbertext">${vo.title }</div>
				<%-- <div class="numbertext">${stat.count} / </div> --%>
				<img src="/upload/${pic}" width="400px" height="400px" style="object-fit:cover">
				<div class="text">${pic}</div>
			</div>
		</c:forEach>
		<!-- Next and previous buttons -->
		
		<div style="text-align:center;">
			<c:forEach items="${vo.filenames }" var="no" varStatus="stat">
			  <span class="dot" onclick="currentSlide(${main.count },${stat.count})"></span>
			</c:forEach>
		</div>	
		</div>
		
		<a class="prev" onclick="plusSlides(${main.count },-1)">&#10094;</a> 
		<a class="next" onclick="plusSlides(${main.count },1)">&#10095;</a>
	</div>

	</c:forEach>

<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/gallery.js">
</script>

</body>
</html>