<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--
	include �ٸ� servlet�������� ������ �����ͼ� ó���ϰų�, 
	forward �ٸ� servlet�������� �Ѱܼ� ó���ϰ� ���ش�. 
	
	�̷� ������ layout���뿡 ���Ǳ⵵ �Ѵ�. 
	

--%>
<div align = "center">
<b style="font-size: 20pt;">SEARCH?</b> <input type="text" size="25" style="font-size: 20pt;" id="searchtext"
	onkeyup="searchView()"/>
</div>
<div align = "center" id="view">
</div>

<script>

function searchView (){
    var searchtext = document.getElementById("searchtext").value;
    var req = new XMLHttpRequest();
    req.open("get","/file/fileSearch.do?sea="+searchtext,true);
	req.onreadystatechange = function(){
	    if(req.readyState == 4 && req.status == 200){
		    rst = req.responseText;
		    if(rst != ""){
		   		document.getElementById("view").innerHTML = "�����˻��� : "+rst;
		    }else{
		    	document.getElementById("view").innerHTML = ""
		    }
		}
	}
    req.send();
}

function search2 (){
	var xhr = new XMLHttpRequest();
	var url = "/file/searchJSON.do?q="+document.getElementById("srch").value;
	xhr.open("get",url,true);
	xhr.onreadystatechange = function() {
		if(xhr.readyState==4 && xhr.status==200){
			var list = JSON.parse(xhr.responseText);
			var html ="";
			console.log(xhr.responseText);
			for(var i=0; i<list.length; i++) {
				console.log(list[i].title);
				html+="<option>"+list[i].title+"</option>";
			}
			document.getElementById("srchrst").innerHTML = html;
			console.log(html);
		}
		xhr.send();
	}
}

</script>
