<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>리뷰 남기기</h3>
<hr/>
<div>
	<form action="/review/Writerst.do" method="post">
	<input type="hidden" name="writer" value="${sid }"/>
	<textarea name="memo" rows="3" cols="80" id="memo"></textarea>
	<span id="textview">(0/400)</span>
	<hr/>
	<input type="submit" value="등록"/>
	</form>
</div>    
<script>
	var tm = document.getElementById("memo");
	tm.addEventListener("keyup",function(){
		document.getElementById("textview").innerHTML="("+tm.value.length+"/400)";
	});
</script>