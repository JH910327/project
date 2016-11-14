<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:choose>
		<c:when test="${log }">
		ID <b>${sid }</b>님 환영합니다. </br>
		</c:when>
		<c:otherwise>
		아이디가 존재하지 않거나 비밀번호가 맞지 않습니다.
		</c:otherwise>
	</c:choose>
 <meta http-equiv = "refresh" content="2;url='/main.do'">