<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <meta name="generator" content="HTML Tidy, see www.w3.org">

    <title>MVC Demo</title>
  </head>

  <body>
    <h3>MVC Demo</h3>
    <c:set target="${myCoolBean}" property="data" value="yellow"/>

    <p>Data from my bean: ${myCoolBean.data}</p>


    <br />

    <a href="/java112">Home</a>
  </body>
</html>
