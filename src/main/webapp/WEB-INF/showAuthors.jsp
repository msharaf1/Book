<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCType html>
<head>
    <title>Authors List</title>
</head>
<body>
    <h1>Authors List</h1>
  <table>
    <table>
        <thead>
            <tr>
                <td>First Name: </td>
                <td>Last Name: </td>
                <td>Address: </td>
                <td>Email Address: </td>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${authorCom}" var="author"> 
            <tr>
              <td> ${author.firstName} </td>
              <td> ${author.lastName} </td>
              <td> ${author.address} </td>
              <td> ${author.email} </td>
            </tr>
      </c:forEach>
        </tbody>
    </table>
  </table>

  <a href="/books"><button type="button"> Home </button> </a>
    
    



    

</body>
</html>
