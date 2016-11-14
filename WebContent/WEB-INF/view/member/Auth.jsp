<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>사용자 인증</h3>
(※ 인증받을 메일 주소를 작성후 인증 키를 요청해주세요.)<br/>
<form action="">
<b>Email주소 입력</b>
<br/>
<input type="email" name="" id="em" size="30"/>
<input type="button" value="인증 키 요청" id="btt"/>
<br/>
<b>키 입력</b><br/>
<input type="text" name="" size="30"/>
<input type="submit" value="인증받기"/>
</form>
<script>
	document.getElementById("btt").addEventListener("click", function(){
		console.log()
		var url = "/member/authAjax.do?email="+document.getElementById("em").value;
		url += "&id=${sid}";
		console.log(url);
		var xhr = new XMLHttpRequest();
		xhr.open("get",url,true);
		xhr.onreadystatechange = function() {
			if(xhr.readyState==4 && xhr.status==200) {
				var resp = xhr.responseText;
				if(resp == "yes") {
					window.alert("인증키값이 발송되었습니다.");
				}else {
					window.alert("키 발송에 실패했습니다.");
				}
			}	
		};	
		xhr.send();
	});
</script>