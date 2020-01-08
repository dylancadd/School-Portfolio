<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <meta name="generator" content="HTML Tidy, see www.w3.org">
    <title>Exam 2 Part 2 - #3</title>
  </head>
  <body>
    <c:set target="${simpleBean}" property="name" value="yellow"/>
    <c:set target="${simpleBean}" property="count" value="17"/>

    <p>Name: ${simpleBean.name}</p>
    <p>Count: ${simpleBean.count}</p>

    <ol>
        <c:forEach var="item" items="${simpleBean.notes}">
            <li>${item}</li>
        </c:forEach>
    </ol>

    <c:remove var="simpleBean" scope="session" />
  </body>
</html>
