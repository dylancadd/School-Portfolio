package java112.project2;

// Import selected packages
import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.text.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is my first servlet for Project 2
 *
 *@author    djcadd
 */
@WebServlet(
    name = "First112Servlet",
    urlPatterns = { "/first" }
)
public class First112Servlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request the HttpServletRequest object
     *@param  response the HttpServletResponse object
     *@exception  ServletException if there is a Servlet failure
     *@exception  IOException if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>First 112 Servlet</TITLE>");
        out.print("<link rel='stylesheet' type='text/css' href='css/simpleServlet.css'>");
        out.print("</HEAD");
        out.print("<BODY>");
        out.print("<h1>First 112 Servlet</h1>");
        out.print("<table>");
            out.print("<tr>");
                out.print("<td>Name</td>");
                out.print("<td>Dylan Cadd</td>");
            out.print("</tr>");
            out.print("<tr>");
                out.print("<td>Course</td>");
                out.print("<td>Advanced Java</td>");
            out.print("</tr>");
            out.print("<tr>");
                out.print("<td>Image</td>");
                out.print("<td><img src='images/marvel.jpg' alt='Marvel Logo' width='200' height='100'</td>");
            out.print("</tr>");
        out.print("</table>");
        out.print("<br><a href='/java112'>Home Page Link</a><br><br>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}
