package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This class demonstrates getting input fields from an HTML form
 *
 *@author    djcadd
 */
@WebServlet(
    name = "lab41",
    urlPatterns = { "/lab3-html-form" }
)
public class Lab41Servlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               Description of the Parameter
     *@param  response              Description of the Parameter
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException {

        String  param1 = request.getParameter("param1");

        System.out.println("param1: " + param1);

        String  param2 = request.getParameter("param2");

        System.out.println("param2: " + param2);

        // Sets the content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>Results</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Param 1:" + param1 + "</h1>");
        out.print("<h1>Param 2:" + param2 + "</h1>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}
