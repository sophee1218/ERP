<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/grade/grade-insert" id="frm">
	<table border="1">
		<tr>
			<th>직급번호</th>
			<th><input type="text" name="grd_no" ></th>
		</tr>
		<tr>
			<th>직급</th>
			<th><input type="text" name="grd_name" ></th>
		</tr>
		<tr>
			<th>설명</th>
			<th><input type="text" name="grd_desc" ></th>
		</tr>
		<tr>
			<th colspan="2"><button>직급추가</button><button type="reset">초기화</button></th>
		</tr>
	</table>
</form>
</body>
</html>