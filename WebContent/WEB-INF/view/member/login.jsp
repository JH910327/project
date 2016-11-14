<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<c:choose>
	<c:when test="${sid == null }">
<h2>로그인</h2>
	<fieldset>
		<form action = "/memberlogin.do">
			<c:choose>
				<c:when test="${!co}">
					<b>ID</b>	<input type = "checkbox" name = "rem"/>
					<span style = "font-size:8pt">아이디 기억하기</span>
					<br/><input type="email" name="id" required = "required"/><br/> 
				</c:when>
				<c:otherwise>
					<b>ID</b>	<input type = "checkbox" name = "rem" checked = "checked"/>
					<span style = "font-size:8pt">아이디 기억하기</span>
					<br/><input type="email" name="id" required = "required" value = "${remid }"/><br/> 
				</c:otherwise>
			</c:choose>
			
		<b>PASS</b><br/><input type="password" name="pass" required = "required"/>
		<hr/>
		<input type="submit" value="확인"/>
		</form>
		<a href = "/memberJoin.do">회원가입</a>
	</fieldset>
	</c:when>
	<c:otherwise>
		<fieldset>
		<b>${sid }</b><br/>
		<c:if test="${admin}">
			<a href = "/admin/">관리자 모드</a>
		</c:if>
		<hr/>
			<ul>
				<li><a href = "/">초기화면</a></li>
				<li><a href = "/member/auth.do">내 정보</a></li>
				<li><a href = "/charge/doCh.do">충전하기</a></li>
				<li><a href = "/charge/chargelog.do">충전내역 확인</a></li>	
				<li><a href = "/review/list.do?page=1">리뷰 리스트</a></li>	
				<li><a href = "/file/list.do">파일 리스트</a></li>	
				<li><a href = "/file/reg.do">파일 업로드</a></li>	
				<li><a href = "/socket/view.do">소켓?</a></li>	
				<li><a href = "/memberlogout.do">로그아웃</a></li>	
			</ul>
		</fieldset>
	</c:otherwise>
</c:choose>