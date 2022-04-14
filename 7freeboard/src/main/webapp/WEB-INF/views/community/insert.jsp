<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>우리동네 커뮤니티</title>
<!-- ContextPath : 현재 프로젝트의 url -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/freeboard.css?v=3">
</head>
<body>
<h3>동아리 커뮤니티</h3>
<hr>
<form name="frm1" method="post" action="insert">
 <input type="hidden" name="ip" value="${pageContext.request.remoteAddr}">  <!-- 클라이언트 ip -->
 <table style="width:80%;">
 	<tr><td width="30%" class="td1">제목</td>
 		<td class="left"><input type="text" name="subject" size="70" class="input1" required="required"></td>
 	</tr>
 	<tr><td class="td1">작성자</td>
 		<td class="left"><input type="text" name="name" size="70" class="input1" required="required"></td>
 	</tr>
 	
 	<tr><td class="td1">글 비밀번호</td>
 		<td class="left"><input type="password" name="password" size="70" class="input1" required="required"></td>
 	</tr>
 	<tr><td class="td1">내용</td>  <!-- textarea 의 크기 : rows="20" cols="80" -->
 		<td class="left"><textarea  rows="20" cols="80" name="content" class="input1" required="required"></textarea></td>
 	</tr>
 	<tr><td colspan="2" align="center">
 	<input type="submit" value="저장" class="btn" >
 	<!-- <a class="button" href="javascript:post_data();">저장</a> -->
 	<input type="reset"  value="다시쓰기" class="btn">
 	<input type="button" value="목록" onclick="location.href='list?pageNo=${page}'" class="btn">
 <!-- 	<a class="button" href="#">목록</a>  -->
 	</td></tr>
 </table>
 </form>
</body>
</html>