<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h3>파일 리스트</h3>
총 ${filesize }개의 자료가 있습니다.
<hr />

<b>인기 다운로드</b>
|
<c:forEach var="td" items="${topdown }">
	<a href="#file${td.num }"><span style="color: black">${td.title}</span></a>&nbsp;
</c:forEach>

<hr />

<c:forEach var="t" items="${al }">
	<p id="file${t.num }">
		no.${t.num } | ${t.ctg } | <a href="/file/down.do?num=${t.num }"><b
			style="color: black">${t.title}</b> </a> &nbsp; | ${t.filename }
		<c:choose>
			<c:when test="${t.filesize < 1024*1024 }">
			(<fmt:formatNumber value="${t.filesize/1024 }" /> KB)
		</c:when>
			<c:when test="${t.filesize < 1024*1024*1024 }">
			(<fmt:formatNumber value="${t.filesize / (1024*1024) }" /> MB)
		</c:when>
			<c:otherwise>
			(<fmt:formatNumber value="${t.filesize / (1024*1024*1024) }" /> GB)	
		</c:otherwise>
		</c:choose>
		<br /> 작성자 : ${t.uploader } | 다운로드수 : ${t.count }
	<hr />
</c:forEach>
<script>
	window.onload = function() {
		var ws = new WebSocket("ws://192.168.10.11/socket/alert.do");
		ws.onmessage = function() {
			window.alert("새자료가 추가되었습니다.");

		}
	}
</script>