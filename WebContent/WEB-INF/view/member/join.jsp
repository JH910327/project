<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<form action = "/memberjoinrst.do" method="post" onsubmit="return valueCheck()">
	* 기본 정보 입력 *<br/>
	ID <input type = "email" name = "id" required = "required" id="idpart"/> <span id="view"></span><br/>
	PASS <input type = "password" name = "pass" required = "required"/><br/>
	NAME <input type = "text" name = "name" required = "required"/><br/>
	<input type = "submit"/>
</form>

<script>

	var check=false;
	
	
	<%-- 아이디 중복체크 ajax --%>
	var rst;
	var idt = document.getElementById("idpart");
	idt.addEventListener("blur",function(){
		var idtext = document.getElementById("idpart").value;
	    var req = new XMLHttpRequest();
	    req.open("get","newmemIdCheck.do?id="+idtext,true);
		req.onreadystatechange = function(){
		    if(req.readyState == 4 && req.status == 200){
		    	rst = req.responseText;
		    	if(rst=="Y"){
		    		check=true;
		    		document.getElementById("view").innerHTML = " 멋진 아이디네요!";
		    	}else{
		    		check=false;
		    		document.getElementById("view").innerHTML = " 아이디가 중복됩니다.";
		    	}
	   	    }
		}
	    req.send();
	});
	
	
	<%-- 중복시 가입 불가처리 --%>
	function valueCheck(){
		if(check){
			return true;
		}else{
			return false;
		}
	}
	
</script>