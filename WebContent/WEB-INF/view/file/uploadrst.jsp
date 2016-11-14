<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<c:choose>
		<c:when test="${uprst }">
		업로드에 성공했습니다. 
		</c:when>
		<c:otherwise>
		문제가 있어 업로드에 실패했습니다. 
		</c:otherwise>
	</c:choose>
 <meta http-equiv = "refresh" content="2;url='/file/list.do'">