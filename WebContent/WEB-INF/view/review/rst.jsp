<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
<c:when test="${rvrst}">
<h2>글 작성에 성공했습니다.</h2>
<meta http-equiv = "refresh" content="3;url='/review/list.do'">
</c:when>
<c:otherwise>
글 작성에 실패했습니다.
<meta http-equiv = "refresh" content="3;url='/review/list.do'">
</c:otherwise>
</c:choose>
