<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.sql.*"%>
<%@ page import = "org.apache.ibatis.session.*" import = "java.io.*" import = "java.util.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<c:choose>
	<c:when test="${joinrst }">
		<h2>������ ȯ���մϴ�!</h2>
		<a href = "/main.do">�ʱ�ȭ������ �̵�</a>
	</c:when>
	<c:otherwise>
		<h2>���Կ� �����߽��ϴ�.</h2>
		<a href = "/memberJoin.do">�ڷΰ���</a>
	</c:otherwise>
</c:choose>















