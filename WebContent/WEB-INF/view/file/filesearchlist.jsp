<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h3>파일 리스트</h3>
총 ${filesize }개의 자료가 있습니다.
<hr/>

<c:forEach var="t" items="${al }">
	no.${t.num } | ${t.ctg } | <a href="/file/down.do?num=${t.num }"><b>${t.title}</b>
	</a> &nbsp; | ${t.filename }	
	<c:choose>
		<c:when test="${t.filesize < 1024*1024 }">
			(<fmt:formatNumber value="${t.filesize/1024 }"/> KB)
		</c:when>
		<c:when test="${t.filesize < 1024*1024*1024 }">
			(<fmt:formatNumber value="${t.filesize / (1024*1024) }"/> MB)
		</c:when>
		<c:otherwise>
			(<fmt:formatNumber value="${t.filesize / (1024*1024*1024) }"/> GB)	
		</c:otherwise>
	</c:choose><br/>
	작성자 : ${t.uploader } | 다운로드수 : ${t.count }
	<hr />
</c:forEach>