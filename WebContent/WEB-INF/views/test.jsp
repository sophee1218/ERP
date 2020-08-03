<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%=request.getParameter("sido") %><br>
시도 :
<select id="sido" onchange="changeSido(this)">
	<option value="">선택</option>
	<c:forEach items="${sidoList}" var="sido">
		<option value="${sido}"
		<c:if test="${sido==param.sido}">
		selected
		</c:if>
		>${sido}</option>
	</c:forEach>
	</select><br>
구군:
<select id="gugun" onchange="changeGugun(this)">
	<option value="">선택</option>
	<c:forEach items="${gugunList}" var="gugun">
		<option value="${gugun}"
		<c:if test="${gugun==param.gugun}">
		selected
		</c:if>
		>${gugun}</option>
	</c:forEach>
</select><br>
동:
<select id="dong" onchange="changeDong(this)">
	<option value="">선택</option>
	<c:forEach items="${dongList}" var="dong">
		<option value="${dong}"
		<c:if test="${dong==param.dong}">
		selected
		</c:if>
		>${dong}</option>
	</c:forEach>
</select>

<script>
function changeSido(obj){
	location.href='/test?sido=' + obj.value;
}
function changeGugun(obj){
	var sidoObj = document.querySelector('#sido');
	location.href='/test?sido=' + sidoObj.value + '&gugun=' + obj.value;
}


</script>
</body>
</html>