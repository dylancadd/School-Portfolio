package java112.project3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  Part of the mid-term exam
 *
 *@author    djcadd
 */
@WebServlet(
    name = "helloWorldServlet",
    urlPatterns = { "/helloWorld" }
)
public class HelloWorldServlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            // Sets the content type
            response.setContentType("text/html");

            PrintWriter out = response.getWriter();
            out.print("<HTML>");
            out.print("<HEAD><TITLE>Hello World</TITLE></HEAD>");
            out.print("<BODY>");
            out.print("<h1>Hello World!</h1>");
            out.print("</BODY>");
            out.print("</HTML>");
            out.close();
    }
}
