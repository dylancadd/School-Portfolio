<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta name="generator" content="HTML Tidy, see www.w3.org" />

    <title>First JSP - Lab 01</title>
  </head>

  <body>

    <!-- HTML Comment -->
    <%-- This is a JSP comment --%>

    <h3>This is an image.</h3>
    <img src='images/marvel.jpg' alt='Marvel Logo' width='200' height='100'>

    <p>Right now it is <%= new java.util.Date() %></p>

    <p><a href="/java112">Home</a></p>
  </body>
</html>
