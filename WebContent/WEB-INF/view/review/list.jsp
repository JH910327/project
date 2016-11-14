<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h3>리뷰 리스트</h3>
<hr/>
<c:forEach var="t" items="${al }">
	<b>no.${t.num }</b> ${t.writer } ${hm }
	<span style="font-size: 9pt"><fmt:formatDate value="${t.writedate }" pattern="yy/MM/dd hh:mm"/>
	(좋아요 : <fmt:formatNumber value ="${t.good }" /> )</span>
	<span onclick="likein(${t.num })"><img src="http://192.168.10.11/image/like.png"></span>
	<br />
	<pre>${t.memo }</pre>
	<hr />
</c:forEach>
<c:forEach var="it" begin="1" end="${pl }" step="1">
	<c:choose>
		<c:when test="${np == it }">
			<b>${it }</b>
		</c:when>
		<c:otherwise>
			<span style="color: black"><a href="/review/list.do?page=${it }">${it }</a></span>
		</c:otherwise>
	</c:choose>
	|
</c:forEach>
<a href="/review/Write.do">리뷰 작성</a>

<hr/>

<script>


	function likein(num) {
		var xhr = new XMLHttpRequest();
		xhr.open("post", "/new/comments/like/"+num, true);
		xhr.send();
		readall();
	};


	function readall() {
		location.reload(true);
	};
</script>
