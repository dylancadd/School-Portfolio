package java112.project2;

// Import selected packages
import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.text.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.utilities.*;

/**
 *  This is a servlet that displays information from a properties file
 *
 *@author    djcadd
 */
@WebServlet(
    name = "PropertiesServlet",
    urlPatterns = { "/properties" }
)
public class PropertiesServlet extends HttpServlet implements PropertiesLoader {

    // Create instance variable
    private Properties properties;

    // Whenever this class is called, load these properties into a variable
    public void init() {
        properties = loadProperties("/project2.properties");
    }

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
        out.print("<HEAD><TITLE>Properties Servlet</TITLE>");
        out.print("<link rel='stylesheet' type='text/css' href='css/simpleServlet.css'>");
        out.print("</HEAD");
        out.print("<BODY>");
        out.print("<h1>Properties Servlet</h1>");
        out.print("<table>");
            out.print("<tr>");
                out.print("<td>Author</td>");
                out.print("<td>" + properties.getProperty("author") + "</td>");
            out.print("</tr>");
            out.print("<tr>");
                out.print("<td>Email</td>");
                out.print("<td>" + properties.getProperty("author.email.address") + "</td>");
            out.print("</tr>");
            out.print("<tr>");
                out.print("<td>Course Title</td>");
                out.print("<td>" + properties.getProperty("course.title") + "</td>");
            out.print("</tr>");
            out.print("<tr>");
                out.print("<td>Course Meeting</td>");
                out.print("<td>" + properties.getProperty("course.meeting") + "</td>");
            out.print("</tr>");
            out.print("<tr>");
                out.print("<td>Instructor Name</td>");
                out.print("<td>" + properties.getProperty("instructor.name") + "</td>");
            out.print("</tr>");
            out.print("<tr>");
                out.print("<td>Project Description</td>");
                out.print("<td>" + properties.getProperty("project.description") + "</td>");
            out.print("</tr>");
        out.print("</table>");
        out.print("<br><a href='/java112'>Home Page Link</a><br><br>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();


    }

}
