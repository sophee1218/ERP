<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>

var person ='{"name":"동동","age":2,"address":"중랑구","hobby":"겜"}';


	
	
	person = JSON.parse(person);
	alert(person.name+',' + person.age + ',' + person.address+','+person.hobby);
</script>
</body>
</html>