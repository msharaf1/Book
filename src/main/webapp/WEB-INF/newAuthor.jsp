<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Authors</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">	
		<%-- <script src="/js/main.js"></script> --%>
	</head>

	<body>
		<form:form action="/authors/new" method="post" modelAttribute="authorObj">
				<form:label path="firstName">First Name:
					<form:errors path="firstName"></form:errors>
					<form:input path="firstName"></form:input>
				</form:label>
				<form:label path="lastName">Last Name:
					<form:errors path="lastName"></form:errors>
					<form:input path="lastName"></form:input>
				</form:label>
				<form:label path="address">Address:
					<form:errors path="address"></form:errors>
					<form:input path="address"></form:input>
				</form:label>
				<form:label path="email">Email:
					<form:errors path="email"></form:errors>
					<form:input path="email"></form:input>
				</form:label>

				<input type="submit" value="Register" />
		</form:form>
	</body>
</html>