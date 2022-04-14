<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>우리동네 커뮤니티</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/freeboard.css">
</head>
<body><!-- list.jsp에서 pageNo 파라미터를 get>post로 수정해서 url에 안보이게 합니다.-->
<h3>우리동네 커뮤니티</h3>
<hr>
<div style="margin:auto;">
 <table>
 	<tr><th width="10%">번호</th>
 		<th width="45%">제목</th>
 		<th width="15%">작성자</th>
 		<th width="10%">조회수</th>
 		<th width="20%">작성일</th></tr>
 	<c:forEach var="vo" items="${list}">
	<tr>
		<td>${vo.idx }</td> 	
 		<td><a href="detail?idx=${vo.idx}&pageNo=${page.pageNo}" class="title">${vo.subject }</a>
 		...<span style="color:orange;font-size: 80%;">(${vo.commentCount})
 		</span></td>
 		<td>${vo.name }</td>
 		<td>${vo.readCount }</td>
 		<td>
 		<!-- wdate 타입을 클래스에서 LocalDateTime 으로 했을때 날짜시간을 문자열 yyyy-MM-dd'T'HH:mm 형식이다.
 			 wdate필드값을 pattern으로 파싱(형식을 맞춤)-->
 	<%-- 	<fmt:parseDate pattern="yyyy-MM-dd'T'HH:mm" value="${vo.wdate }" var="wdate"/> --%>
 		<fmt:formatDate value="${vo.wdate }" pattern="yyyy-MM-dd"/>  <!-- 출력패턴 -->
 		</td>
 	</tr>
 	</c:forEach>
 	<tr><td colspan="4">Go!
 	<!-- a태그 url요청 get 메소드 -->
 	<a class="button" href="insert?pageNo=${page.pageNo }">글쓰기</a>
 	<a class="button" href="${pageContext.request.contextPath }">홈</a></td>
 	<td>작성글 총 개수 : ${page.totalCount}</td>
 	</tr>
 </table>
</div>
 <!-- 페이지 이동 :전체보기 -->
 
 <div style="text-align: center;">		<!-- a태그에서 onclick 사용할 땐 자바스크립트라고 표시 -->
	<a class="pagenum" onclick="javascript:goPage(1)">&lt;&lt;</a>   <!-- 요청url은 동일하고 파라미터만 변경됩니다. -->
	<a class="${page.startPage>1? 'pagenum':'none'}" 
		 onclick="javascript:goPage('${page.startPage-1 }')">&lt;</a>  
	
	<c:forEach var="i" begin="${page.startPage }" end="${page.endPage}">  <!-- 페이지목록의 범위  -->
		<a class="pagenum" onclick="javascript:goPage('${i}')">${i}</a>     <!-- 현재페이지 i값으로 변경  -->
	</c:forEach>
	
	<a class="${page.endPage!=page.totalPage? 'pagenum':'none'}" 
		onclick="javascript:goPage('${page.endPage+1 }')">&gt;</a> 
	<a class="pagenum" onclick="javascript:goPage('${page.totalPage }')">&gt;&gt;</a>
</div>
<form action="" method="post">
	<input name="pageNo" type="hidden">
</form>
<script type="text/javascript">
	function goPage(no){
		const frm = document.forms[0];
		frm.action='list';
		frm.pageNo.value=no;
		frm.submit();
	}
</script>
</body>
</html>








