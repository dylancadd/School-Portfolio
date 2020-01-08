<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta name="generator" content="HTML Tidy, see www.w3.org" />

    <title>JSP Scriptlets</title>
  </head>

<%

String bgColor = request.getParameter("bgColor");

if((bgColor == null) || (bgColor.trim().equals(""))) {
    bgColor = "WHITE";
}

String color = request.getParameter("color");

color = "RED";

String font = request.getParameter("font-size");
font = "2em";

%>

  <body bgcolor="<%= bgColor %>">
    <h3 style="font-size:<%= font %>; color:<%= color %>">JSP Scriptlets</h3>


<%

String usingScriptlets = "A JSP scriptlet is used to run arbitrary java code on the JSP page<br>";

out.println(usingScriptlets);

%>
    <p>Bad Examples</p>
    <ul>
        <li>Presentation logic and business logic should not be mixed</li>
        <li>Reusability - Not duplicatable</li>
        <li>Maintainability - Won't be able to find changes through the database</li>
        <li>Breaks Object Orientated Programming</li>
        <li>Hard to debug</li>
    </ul>

    <p>Scriptlets are about 15 years outdated but you will see them so you should know how to use them</p>
    <p><a href="/java112">Home</a></p>
  </body>
</html>
