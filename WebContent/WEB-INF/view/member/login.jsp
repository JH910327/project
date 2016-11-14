<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<c:choose>
	<c:when test="${sid == null }">
<h2>�α���</h2>
	<fieldset>
		<form action = "/memberlogin.do">
			<c:choose>
				<c:when test="${!co}">
					<b>ID</b>	<input type = "checkbox" name = "rem"/>
					<span style = "font-size:8pt">���̵� ����ϱ�</span>
					<br/><input type="email" name="id" required = "required"/><br/> 
				</c:when>
				<c:otherwise>
					<b>ID</b>	<input type = "checkbox" name = "rem" checked = "checked"/>
					<span style = "font-size:8pt">���̵� ����ϱ�</span>
					<br/><input type="email" name="id" required = "required" value = "${remid }"/><br/> 
				</c:otherwise>
			</c:choose>
			
		<b>PASS</b><br/><input type="password" name="pass" required = "required"/>
		<hr/>
		<input type="submit" value="Ȯ��"/>
		</form>
		<a href = "/memberJoin.do">ȸ������</a>
	</fieldset>
	</c:when>
	<c:otherwise>
		<fieldset>
		<b>${sid }</b><br/>
		<c:if test="${admin}">
			<a href = "/admin/">������ ���</a>
		</c:if>
		<hr/>
			<ul>
				<li><a href = "/">�ʱ�ȭ��</a></li>
				<li><a href = "/member/auth.do">�� ����</a></li>
				<li><a href = "/charge/doCh.do">�����ϱ�</a></li>
				<li><a href = "/charge/chargelog.do">�������� Ȯ��</a></li>	
				<li><a href = "/review/list.do?page=1">���� ����Ʈ</a></li>	
				<li><a href = "/file/list.do">���� ����Ʈ</a></li>	
				<li><a href = "/file/reg.do">���� ���ε�</a></li>	
				<li><a href = "/socket/view.do">����?</a></li>	
				<li><a href = "/memberlogout.do">�α׾ƿ�</a></li>	
			</ul>
		</fieldset>
	</c:otherwise>
</c:choose>