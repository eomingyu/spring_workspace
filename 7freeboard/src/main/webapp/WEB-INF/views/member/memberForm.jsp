<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        td,th{
            border-top: 1px solid gray;
            border-bottom: 1px solid gray;
            padding: 5px 10px;
            
        }
        th {
            background-color: teal;
            color: white;
        }
        tr:hover{
            background-color: darkseagreen;
            color: white;
            cursor: pointer;
        }
       
        tr > td:nth-child(1){
            width : 15%;
        }
        tr > td:nth-child(2){
            width : 30%;
        }
        tr > td:nth-child(3){
            width : 15%;
        }
        tr > td:nth-child(4){
            width : 40%;
        }

    </style>
</head>
<body>
    <h3>AJAX - 비동기통신</h3>
    <button id="getAll">GET</button>
    <button id="getOne">GET ONE</button>
    <button id="post">POST</button>
    <button id="put">PUT</button>
    <button id="patch">PATCH</button>
    <button id="delete">DELETE</button>
    <br>
    <input type="text" id="mno" placeholder=" mno를 입력하세요.">
    <input type="text" id="name" placeholder=" name를 입력하세요.">
    <input type="text" id="age" placeholder=" age를 입력하세요.">
    <input type="text" id="hobbies" placeholder=" 취미를 입력하세요.(,로 구분)">
    <div id='hobby'>
        <input type="checkbox" class="hobby" value="축구" id="football"><label for="football">축구</label>
        <input type="checkbox" class="hobby" value="달리기" id="running"><label for="running">달리기</label>
        <input type="checkbox" class="hobby" value="농구" id="basketball"><label for="basketball">농구</label>
        <input type="checkbox" class="hobby" value="스키" id="ski"><label for="ski">스키</label>
        <input type="checkbox" class="hobby" value="수영" id="swim"><label for="swim">수영</label>
    </div>
    <table id="list" style="width: 60%;border-collapse: collapse;">


    </table>
    <pre></pre>

    <script>
        //버튼에 대한 이벤트 리스너
        document.querySelector('#getAll').addEventListener('click',function(){
            const xhr = new XMLHttpRequest();
            xhr.open('GET','./ajaxex');      //ajax 요청 준비 (요청메소드, url )
            xhr.send();         //ajax 요청 전송

            //xhr 객체에 대한 이벤트 리스너 
            //onload : **요청이 성공적으로 완료되었을 때 동작합니다.
            xhr.onload=function(){
                    if(xhr.status==200) {
                          document.querySelector('pre').innerHTML=xhr.response;
                      
                          const result = JSON.parse(xhr.response);    //json문자열 -> js object 로 변환
                          makeList(result.members);
                    }else {
                        console.error('Error',xhr.status,xhr.statusText);
                    }
            };
        });

        function makeList(list){
        	console.log(list);
           // document.getElementById('list').
            const $title = document.createElement("tr");
                            $title.innerHTML=`
                                <th>번호</th>
                                <th>이름</th>
                                <th>나이</th>
                                <th>취미</th>
                            `;
                        document.getElementById('list').appendChild($title);
                       //응답받은 data (배열)로 반복실행 Array.from(list)
                        list.forEach(function(member){    //배열에서 하나 가져온 member
                            const $tr = document.createElement("tr");
                           /*  const $temp=`<td>${ele.mno}</td>
                                <td>${ele.name}</td>
                                <td>${ele.age}</td>
                                <td>${ele.hobby}</td>
                            `; */
                            
                            const $temp=
                            	'<td>'+ member.mno+'</td>' +
                            	'<td>'+ member.name+'</td>' +
                            	'<td>'+ member.age+'</td>' +
                            	'<td>'+ member.hobby+'</td>' ;
                            $tr.innerHTML=$temp;
                            document.getElementById('list').appendChild($tr);
                        });
        }


        document.querySelector("#getOne").addEventListener('click',function(){
            const xhr = new XMLHttpRequest();
     //       xhr.open('GET','/member/3');      //get 메소드로 resource 중 id값 1번을 요청
            const mno = document.querySelector('#mno').value;
            if(mno=="") {
                alert('mno 입력은 필수입니다.');
                return;
            }
            xhr.open('GET','./members/'+mno);
            xhr.send();

            xhr.onload = function() {
                if(xhr.status ==200) {
                    document.querySelector('pre').innerHTML=xhr.response;
                    console.log(xhr.response);
                    const customer = JSON.parse(xhr.response).member;
                    document.getElementById('name').value = customer.name;
                    document.getElementById('age').value = customer.age;
                    document.getElementById('hobbies').value = customer.hobby;
                    document.querySelectorAll('.hobby').forEach(item => {
                                 //customer.hobby 에 있는 텍스트가 체크박스 요소의 value 를 포함하고 있는지 각각 비교함.
                        if (customer.hobby.includes(item.value))
                            item.checked = true;
                        else
                            item.checked = false;    
                    });
                    
                }else {
                    console.error('Error',xhr.status,xhr.statusText);
                }
            };
        });


        document.querySelector('#post').addEventListener('click',function(){
        	// const id = document.querySelector('#id_').value;
             const name = document.querySelector('#name').value;
             const age = document.querySelector('#age').value;
             const hobbies = document.querySelector('#hobbies').value;


             const xhr = new XMLHttpRequest();

             xhr.open('POST', './ajaxex');
             //request body(요청 몸체)에 담아 서버로 전송할 페이로드의 MIME 타입을 지정.
             xhr.setRequestHeader('content-type', 'application/json;charset=utf-8');
             xhr.send(JSON.stringify({"name": name,"age": age,"hobby": hobbies}));
             xhr.onload = function(){ // 201:created
                 if (xhr.status === 200 || xhr.status === 201) {
                     document.querySelector('pre').innerHTML = xhr.response;
                     const member =JSON.parse(xhr.response).member;
                     const $tr = document.createElement("tr");
                     /*  const $temp=`<td>${ele.mno}</td>
                          <td>${ele.name}</td>
                          <td>${ele.age}</td>
                          <td>${ele.hobby}</td>
                      `; */
                      
                      const $temp=
                      	'<td>'+ member.mno+'</td>' +
                      	'<td>'+ member.name+'</td>' +
                      	'<td>'+ member.age+'</td>' +
                      	'<td>'+ member.hobby+'</td>' ;
                      $tr.innerHTML=$temp;
                      document.getElementById('list').appendChild($tr);
                     
                     
                 } else {
                     console.error('Error', xhr.status, xhr.statusText);
                 }
             };

        });
        
        //체크 박스 클릭하면 체크 된것 문자열 연결
        document.querySelector('#hobby').addEventListener('click', function () {
            let hobbies = String();
            document.querySelectorAll('.hobby').forEach(item => {
                if (item.checked) hobbies = hobbies.concat(item.value, ",");
            });
            document.querySelector('#hobbies').value = hobbies.substr(0, hobbies.length - 1);
        });

   
    </script>
</body>
</html>