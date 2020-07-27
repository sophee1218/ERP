<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>사원번호</th>
		<th>사원이름</th>
		<th>입사일</th>
		<th>월급</th>
		<th>직급</th>

	</tr>
	<c:if test="${empty empList}">
		<tr>
			<td colspan="3">내용이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach items ="${empList}" var="employee">
		<tr onclick="goView(${employee.emp_no})">
			<td>${emp.emp_no}</td>
			<td>${emp.emp_name}</td>
			<td>${emp.emp_credat}</td>
			<td>${emp.emp_grd_no}</td>
			<td>${emp.emp_salary}</td>
			
			
		</tr>
	</c:forEach>
</table>
<script>
function goView(emp_no)
{
	location.href='/emlployee/employee-view?emp_no=' + emp_no;
	}
</script>
</body>
</html>