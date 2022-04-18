<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드 테스트</title>
<style type="text/css">
	div{
		width:400px;height: 400px;
		border: 1px solid gray;
		padding:50px;
		margin: 100px auto;
	}
</style>
</head>
<body>
<h3>파일업로드 테스트</h3>
<hr>
<!-- MIME 타입 : multipart/form-data , image/* , application/pdf 등
		웹에서 사용하는 파일의 종류(일반적으로 알고 있는 확장자)
 -->
	<form action="upload2" method="post" enctype="multipart/form-data">
		<input type="text" placeholder="제목입력하세요." name="title"><br>
		이미지 파일을 선택하세요.(최대 3개)<br>
		<input type="file" name="docs" accept=".pdf,.hwp"><br>
		<input type="file" name="docs" accept=".pdf,.hwp"><br>
		<input type="file" name="docs" accept=".pdf,.hwp"><br>
		<button>전송</button>
	</form>
<hr>
<!-- 서버에 업로드된 이미지 파일을 view(화면,클라이언트,jsp) 에서 접근하려면
	 url 이 필요합니다. c:/uplaod 서버 폴더에 파일을 저장했으나 클라이언트에서는 폴더로 
	 접근하는 것이 아니고 url(예, /upload)로 접근해야 합니다. server.xml 에서 설정합니다.
 -->
	<c:if test="${not empty fileNames}"> 
	<c:forEach var="i" begin="0" end="${fileNames.size()-1}">
	파일명:	${fileNames[i] } ,${origins[i] }
	(파일사이즈: ${fileSizes[i]})
	
	<a href="fileDownload?file=${fileNames[i]}">다운로드</a> <br/>
	
	</c:forEach>
	 </c:if> 
</body>
</html>