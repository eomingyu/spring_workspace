/*jsp파일이 자바클래스(서블릿)으로 변환되고
	그 후 script태그의 src로 설정된 파일을 삽입하여 처리되므로
	js 파일로 외부에 있으면 el을 사용하여 값을 가져올수 없습니다.
	-> detail.jsp에 스크립트를 옮겨 넣어주세요.*/

function update(){
    document.getElementById('cont').innerHTML=`
    <form>
                <input type="hidden" name="idx" value="{bean.idx}">
                <input type="hidden" name="pageNo" value="{page}">
                <textarea  rows="20" name="content" class="input1" 
                style="border:1px solid gray;width:90%" required="required">{bean.content}</textarea>
    </form>
    `;

    document.getElementById('func').innerHTML=`
        <a class="button" onclick="javascript:save()">저장</a>
        <a class="button" onclick="javascript:reset()">취소</a>
    `;
}
function reset(){
    document.getElementById('cont').innerHTML=`
        <pre>{bean.content }</pre>
    `;

    document.getElementById('func').innerHTML=`
        <a class="button" onclick="javascript:update()">수정</a>
        <a class="button" onclick="javascript:deleteOk();">삭제</a>
    `;

}

function save(){
    document.forms[0].action='update';
    document.onsubmit();
}
