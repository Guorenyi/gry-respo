<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>对不起，程序出现了错误，请与管理员联系！</h1>
<c:if test="${errors != null}">
	<h2>对不起，程序出现了如下的错误：</h2>
	<c:forEach items="${errors}" var="entry">
		<li>${entry.key} = ${entry.value}</li>
	</c:forEach>
</c:if>
</body>
</html>