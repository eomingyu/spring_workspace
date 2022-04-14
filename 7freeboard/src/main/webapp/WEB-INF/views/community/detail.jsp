<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/freeboard.css">
</head>
<body>
<h3>우리동네 커뮤니티</h3>
<hr>
 <table style="width:80%;margin:auto;">
 	<tr><td width="20%" class="td1">제목</td>
 		<td width="40%" class="input1">${bean.subject}</td>
 		<td width="20%" class="td1">조회수</td>
 		<td class="input1">${bean.readCount}</td>
 	</tr>
 	<tr><td class="td1">작성자</td>
 		<td class="input1">${bean.name} 
 		<span style="font-size:70%;padding-left: 30px;">(${bean.ip})</span></td>
 		<td class="td1">작성날짜</td>
 		<td class="input1">
 		<%-- <fmt:parseDate pattern="yyyy-MM-dd'T'HH:mm" value="${bean.wdate }" var="wdate"/> --%>
 		<fmt:formatDate value="${bean.wdate }" pattern="yyyy-MM-dd"/>
 		</td>
 	</tr>
 	<tr><td class="td1">내용</td>
 		<td colspan="3" class="input1" style="text-align: left;">
 		<div  style="height: 300px;">
 		<pre>${bean.content }</pre></div></td>  
 		 <!--pre 태그 엔터,탭,기호 등 텍스트 그대로 출력할 때 사용 -->
 	</tr>
 	<tr>
 	<td colspan="4">
 	<a class="button" href="javascript:update()">수정</a>
 	<a class="button" href="">삭제</a>
 	<a class="button" href="list?pageNo=${page}">목록</a>
 	</tr>
</table>
<!-- 메인 글 상세보기 끝 -->

<!-- 댓글 시작 -->
 <form action="comment?action=insert" method="post" name="frmCmt">
 <input type="hidden" name="mref" value="${bean.idx}">  <!-- 메인글의 idx -->
 <table style="width:60%;margin: auto;">
 	<tr><td colspan="4">댓글 갯수 : ${bean.commentCount }    
 		<input type="button" onclick="window.location.reload()" value="새로고침" class="btn-small">
 	</td>
 	</tr>
 	<tr><td colspan="4"><hr></td></tr>
 	<!-- 댓글 입력 -->
 	<tr>
 		<td width="25%" >작성자</td>
		<td width="25%">
 		<input type="text" name="name" class="input1"></td>
 	</tr>
 	<tr>
 		<td colspan="3">  <!-- 크기조절불가 : style="resize: none;" -->
 			<textarea rows="5" cols="80" name="content"  style="resize: none;" placeholder="댓글을 작성하세요." class="input1"></textarea>
 		</td>
 		<td width="15%" style="text-align: left;">
 			<input type="submit" value="저장" class="btn-small">
 			<input type="reset" value="취소" class="btn-small">
 		</td>
 	</tr>
 	<tr><td colspan="4"><hr></td></tr>
 </table>
 </form>
<!-- 댓글 목록 -->
<script type="text/javascript"
src="${pageContext.request.contextPath}/resources/js/detail_board.js">

</script>
</body>
</html>