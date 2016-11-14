<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
	form을 이용해 client에게 받고 싶은 파일이 있다면? 
	문자 기반의 데이터를 받는 것과는 달리, 몇가지 설정을 바꿔주어야 한다. 
	method="post" enctype="multipart/form-data" 이것
	(원래는 "application/x-www-form-urlencoded", get방식이다 이것은 데이터를 url에 보낸다. 
	 post방식으로 보내면 body의 데이터를 보내게 된다. 
	 파일 전송은 덩치가 크기때문에 이렇게 보내야 함. )
 -->

<h3>자료등록</h3>
<hr/>
<div style="line-height:30px;" style="font-size:10pt">
<form action="/file/upload.do" method="post" enctype="multipart/form-data">
	카테고리#
	<select name="ctg">
		<option value="util">유틸리티</option>
		<option value="game">게임</option>
		<option value="media">미디어</option>
		<option value="image">사진</option>
	</select>
	<br/>
	제목#<input type="text" name="title" size="30"/><br/>
	첨부파일#<input type="file" name="file"/><br/>
	<input type="hidden" name="id" value="${sid}"/>
	<input type="submit" value="등록"/>
</form>
</div>