<%--
  Created by IntelliJ IDEA.
  User: menhaj
  Date: 2019-04-29
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCType html>
<head>
    <title>MSX Books Center</title>
</head>
<body>
    <h1>Server is running</h1>
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
        <c:forEach items="${books}" var="book">
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
    
    



    

</body>
</html>
