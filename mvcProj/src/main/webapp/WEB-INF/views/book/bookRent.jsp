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
        <h4 style="text-align: center;">도서대여</h4>
       <form action="rent" method="post" > 
           <!-- action 설정된 url로 입력요소에 작성된 데이터를 서버로 전송
                form 태그 속성 method="post" 있을때 와 없을때 차이점이 있습니다. -->
           <table style="width: 70%;margin:auto">
               <tr>
                   <td class="col1_title">대여NO</td>
                   <td><input type="text"name="rentno"size="17" 
                   placeholder="자동생성" disabled="disabled">
                   </td> <!-- 입력요소 데이터 식별하는 속성은 name -->
               </tr>
               <tr>
                <td class="col1_title">회원번호</td>
                <td><input type="text"name="mem_idx" size="17" placeholder="회원번호 입력">
                </td>
                <!-- required="redquired 간단히 표현" -->
            </tr>
            <tr>
                <td class="col1_title">도서코드</td>
                <td><input type="text"name="bcode" size="17" placeholder="도서코드 입력">
                <button id="bcode_check" type="button" style="font-size: 0.7em">도서확인</button>
                <br>&nbsp;&nbsp;&nbsp;<span id="checkmsg" style="color:red"></span>
                    </td>
            </tr>
            <tr>
                <td class="col1_title">대여일자</td>
                <td><input type="date"name="rent_date" id="rent_date"></td>
            </tr>
            <tr>
                <td class="col1_title">반납예정일자</td>
                <td><input type="date" name="exp_date" id="exp_date"></td>
            </tr>
            <tr><td colspan="2" style="text-align: center;">
            <button onclick="valid_check()" type="button">대여<br>BOOKRENT</button></td>
            </tr>
           </table>
       </form>
    </section>
    <footer>
        HRDKREA Copyright&copy2022 All rigths reserved. Human Resources Develpment Service of Korea;
    </footer>
    <script>
        //1) 대여일자는 오늘날짜로 자동 출력
    	print_date();
    
        // document.getElementById('rent_date').valueAsDate=new Date()
		var check_bcode=false;
        
        //2) 회원번호, 도서코드 필수입력 유효성 검사
        //3)대여버튼 클릭시 반납예정일자 계산, 화면 알림 출력
        function valid_check(){
            const frm = document.forms[0];
            const mem_idx = frm.mem_idx;  
            const bcode = frm.bcode;
            const exp_date = frm.exp_date.value;
            var isValid = true;
				
        if(mem_idx.value == ""){
            alert('회원번호 입력은 필수입니다.')
            mem_idx.focus();
            isValid=false;
        } else if(bcode.value=="" ){
            alert('도서코드 입력은 필수입니다.')
            bcode.focus();
            isValid=false;
        }else if(check_bcode==false){
            alert('도서코드를 확인하세요.')
            isValid=false;
        }
        
        if(isValid){
            alert('반납예정일자는 '+exp_date+' 입니다.')
            frm.submit();
        }
    }  //fucn 끝
        
    //비동기 통신
        document.querySelector("#bcode_check").addEventListener('click',function(){
        	const frm = document.forms[0];
            const bcode = frm.bcode.value;  
        	const xhr = new XMLHttpRequest();
            if(bcode==""){
          	  	alert('도서코드 입력은 필수입니다.')
                bcode.focus();
          	  	return;
            }
            xhr.open('GET','${pageContext.request.contextPath}/asyncBook/'+bcode);
            xhr.send();

            xhr.onload = function() {
                if(xhr.status ==200) {
                    console.log(xhr.response);
                    const cnt = JSON.parse(xhr.response).cnt;
                    console.log(cnt)
                    if (cnt==1) {
                    	document.querySelector('#checkmsg').innerHTML='대여 가능합니다.';
                    	check_bcode=true;
                    }	
                    else
                    	document.querySelector('#checkmsg').innerHTML='잘못된 도서코드입니다.';
                    
                }else {
                    console.error('Error',xhr.status,xhr.statusText);
                }
            };
            });
        
    function print_date(){
    	var temp=new Date()
        var year = temp.getFullYear();
        var month = (temp.getMonth()+1).toString().padStart(2,0);
        var date_ = temp.getDate().toString().padStart(2,0);
        document.forms[0].rent_date.value=[year,month,date_].join('-')
        //반납일자는 +14일 이후
        temp = new Date(temp.setDate(temp.getDate()+14))
        year = temp.getFullYear();
        month = (temp.getMonth()+1).toString().padStart(2,0);
        date_ = temp.getDate().toString().padStart(2,0);
        document.forms[0].exp_date.value=[year,month,date_].join('-')
    }
        
    </script>
</body>
</html>