<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.sql.*"%>
<%@ page import = "org.apache.ibatis.session.*" import = "java.io.*" import = "java.util.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<c:choose>
	<c:when test="${joinrst }">
		<h2>가입을 환영합니다!</h2>
		<a href = "/main.do">초기화면으로 이동</a>
	</c:when>
	<c:otherwise>
		<h2>가입에 실패했습니다.</h2>
		<a href = "/memberJoin.do">뒤로가기</a>
	</c:otherwise>
</c:choose>















