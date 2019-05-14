<%--
  Created by IntelliJ IDEA.
  User: menhaj
  Date: 2019-04-24
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Add a Book!</title>
</head>
<body>


<h1>Add a new book!</h1>
<%-- <p><form:errors path="books.*"/></p> --%>
<form:form action="/books/new" method="POST" modelAttribute="book">
  <p>
        <form:label path="bookName">Book Name: </form:label>
        <form:errors path="bookName"></form:errors>
        <form:input path="bookName"/>
    </p>
      
    <p>
        <form:label path="publisher">Publisher Name: </form:label>
        <form:errors path="publisher"></form:errors>
        <form:input path="publisher"/>
    </p>
    <p>
        <form:label path="location">Location: </form:label>
        <form:errors path="location"></form:errors>
        <form:input path="location"/>
    </p>

    <%-- <p>
        <form:label path="author_id">Autorid: </form:label>
        <form:errors path="author_id"></form:errors>
        <form:input path="author_id"/>
    </p> --%>
    <input type="submit" value="Submit"/>
</form:form>




</body>
</html>
