<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/freeboard.css">
<script type="text/javascript">
function update(){
    document.getElementById('cont').innerHTML=`
    <form method="post">
                <input type="hidden" name="idx" value="${bean.idx}">
                <input type="hidden" name="pageNo" value="${page}">
                <textarea  rows="20" name="content" class="input1" 
                style="border:1px solid gray;width:90%" required="required">${bean.content}</textarea>
    </form>
    `;
    document.getElementById('func').innerHTML=`
        <a class="button" onclick="javascript:save()">저장</a>
        <a class="button" onclick="javascript:reset()">취소</a>
    `;
}
function reset(){
    document.getElementById('cont').innerHTML=`
        <pre>${bean.content }</pre>
    `;
    document.getElementById('func').innerHTML=`
        <a class="button" onclick="javascript:update()">수정</a>
        <a class="button" onclick="javascript:deleteOk()">삭제</a>
    `;
}
function save(){
    document.forms[0].action='update';
    document.forms[0].submit();
}
function deleteOk(){
	if(confirm(`${bean.idx} 번 글을 삭제하시겠습니까?`)==true){
		document.forms[0].action='delete';
		document.forms[0].submit();
	}
}
/* 	if(confirm(`${bean.idx} 번 글을 삭제하시겠습니까?`)==true){
		location.href=`delete?idx=${bean.idx}&pageNo=${page}`;
		//pageNo=${page}에 해당하는 글 목록으로 이동합니다.
	} */
</script>
<script type="text/javascript">
	if(${message != null}) alert('${message}');
</script>
</head>
<body>
<h3>우리동네 커뮤니티</h3>
<hr>
 <table style="width:750px;margin:auto;">
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
 		<div  style="height: 300px;box-sizing: border-box;" id="cont">
 		<pre>${bean.content }</pre>
 		</div>
 		</td>   
 		<!-- 엔터,탭,기호 등 텍스트 그대로 출력할 때 사용 -->
 	</tr>
 	<tr><td colspan="4">
 		<span id="func"> <!-- freeboard 테이블에 작성자 또는 다른 컬럼이 member 테이블의 유니크 컬럼값 중 하나를 
 		참조하는 외래키가 있어야 합니다. 작성자와 로그인 사용자가 같을 때만 
 		수정, 삭제 버튼이 view에 보이게 합니다.
 		-->
	 		<a class="button" href="javascript:update()">수정</a>
 			<a class="button" href="javascript:deleteOk()">삭제</a>
 		</span>
 		<a class="button" href="list?pageNo=${page }">목록</a>
 		 <form action="" method="post">
 			<input name="idx" type="hidden" value="${bean.idx}">
 			<input name="pageNo" type="hidden" value="${page}">
		 </form>
 	</td>
 	</tr>
 	</table>
 	<!-- 메인글 상세보기 끝 -->
 	
 	<!-- 댓글 시작 -->
 <form action="comment" method="post" name="frmCmt">
 <input type="hidden" name="mref" value="${bean.idx}">  <!-- 메인글의 idx -->
 <input type="hidden" name="ip" value="${pageContext.request.remoteAddr}">  
 <input type="hidden" name="pageNo" value="${page }">
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
 	<!-- 댓글 목록 -->
 	<c:set var="image" value="${pageContext.request.contextPath}/resources/image"/>
	 <c:forEach var="cmt"  items="${cmtlist }">
	 	<tr>
	 		<td colspan="4">
	 			<div id="comment">
		 			<div>
			 			<span class="name">${cmt.name }(${cmt.ip })</span>
			 			<span class="now">
			 			<%-- <fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm" value="${cmt.wdate }" var="wdate"/>${wdate} --%>
			 				<fmt:formatDate pattern="yyyy-MM-dd a hh:mm" value="${cmt.wdate }"/>
			 			</span>
			 			<span style="float: right;">
			 			<!-- comment?idx=${cmt.idx }&pageNo=${page}&mref=${bean.idx} -->
			 			<a href="javascript:delete_cmt('${cmt.idx}')">
			 			<img alt="삭제" src="${image }/delete.png" style="width:20px;"></a>
			 			</span>
		 			</div>
		 			<div style="padding-top: 10px">
		 				<pre style="text-align: left;">${cmt.content }</pre>
		 			</div>
	 			</div>
	 		</td>
	 	</tr>
	 </c:forEach>	
 </table>
	 	<script type="text/javascript">
			function delete_cmt(idx){
				if(confirm('선택한 댓글 삭제하시겠습니까') == true){
					location.href=`comment?idx=`+idx+`&pageNo=${page}&mref=${bean.idx}`;
				}
			}
		</script>
 </form>

</body>
</html>