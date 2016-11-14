<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>웹소켓?</h3>
<!-- 
	html5부터 지원을 했고, 현재는웹어플리케이션에 이 기술을 많이 사용하려고 한다.
	웹소켓은 ajax 를 좀더 한단계 발전시켜둔 업그레이드 기술.
	: 기존웹연결방식(http) 과는 다르게, 계속 서버측과 연결을 시켜둘수가 있고,
	서버로 전달되는 실시간 데이터를 받아서 처리할수 있다.
	웹 채팅 / 혹은.. 새 메시지 알림 처리 같은 것들이 가능. 
	
 -->
<div style="height: 300px; background: #FAF4C0; overflow: scroll;" id="rst">

</div>
<input type="text" size="80" id="msg" />
<script>
	var soc;
	window.onload =  function() {
		try {
			var uri = "ws://192.168.10.11/socket/con.do";
			soc = new WebSocket(uri);
			soc.onopen=function(){
				document.getElementById("rst").innerHTML = "success!" +soc;	
			};
			soc.onmessage = function(evt) {
				var data = evt.data;
				document.getElementById("rst").innerHTML += "<br/>"+data;
			};
		}catch(e){
			document.getElementById("rst").innerHTML = "fail.."+e;
		}
		
	};
	document.getElementById("msg").addEventListener("change", function(){
		var v =  document.getElementById("msg").value;
		document.getElementById("msg").value="";
		soc.send(v);
	});

	
	
	
</script>


