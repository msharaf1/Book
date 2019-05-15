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

<table>
    <table>
        <thead>
            <tr>
                <td>Book Title: </td>
                <td>Publisher: </td>
                <td>Location: </td>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${bookObj}" var="book">
            <tr>
              <td> ${book.bookName} </td>
              <td> ${book.publisher} </td>
              <td> ${book.location} </td>
              <a href="/books/${book.id}" >Show</a>
            </tr>
        </c:forEach>
        </tbody>
    </table>
  </table>


<%-- <p><form:errors path="books.*"/></p> --%>
<form action="/books/add" method="POST">

<p>    bookName<input type="text" name="bookName"/> </p>
<p>    publisher<input type="text" name="publisher"/> </p>
<p>    location<input type="text" name="location"/> </p>

<p>    firstName<input type="text" name="firstName"/></p>
<p>    lastName<input type="text" name="lastName"/></p>
<p>    address<input type="text" name="address"/></p>
<p>    email<input type="text" name="email"/></p>
<p>    AuthorId<input type="text" name="aId"/></p>
    
 

<%-- <select name="authorId">
<c:forEach items="${authorObj}" var="author">
  <option type=number value="author.id">${author.id}</option>
  <input type="number" name="authorId"/>
 </c:forEach>
</select>
         --%>




    
    <input type="submit" value="Submit"/>



  <%-- <p>
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

    <input type="submit" value="Submit"/> --%>
</form>





</body>
</html>
