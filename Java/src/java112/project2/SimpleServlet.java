package java112.project2;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.text.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of a lab and is the first servlet for the course.
 *
 *@author    eknapp
 */
@WebServlet(
    name = "simpleServlet",
    urlPatterns = { "/text" }
)
public class SimpleServlet extends HttpServlet {

    Integer counter = 0;
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
    Date dateFirstAccess;

    public int getCounter() {
        counter++;
        return counter;
    }

    public String getDate() {

	    Date date = new Date();
        String returnDate = "" + date;
        return returnDate;

    }

    public String getFirstAccess() {
        String firstAccess = "" + dateFirstAccess;
        return firstAccess;
    }


    public void init() {
        log("This is a log from init()");
	    dateFirstAccess = new Date();

    }

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

        log("This is a log from doGet()");
        log("This Servlet has been called " + counter + " times.");
        log(getDate());

        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>Simple Servlet</TITLE>");
        out.print("<link rel='stylesheet' type='text/css' href='css/simpleServlet.css'>");
        out.print("</HEAD");
        out.print("<BODY>");
        out.print("<h1>Simple Servlet</h1>");
        out.print("<table>");
            out.print("<tr>");
                out.print("<td>Counter</td>");
                out.print("<td>" + getCounter() + "</td>");
            out.print("</tr>");

            out.print("<tr>");
                out.print("<td>First Accessed</td>");
                out.print("<td>" + getFirstAccess() + "</td>");
            out.print("</tr>");

            out.print("<tr>");
                out.print("<td>Current Time</td>");
                out.print("<td>" + getDate() + "</td>");
            out.print("</tr>");



        out.print("</table>");


        out.print("</BODY>");
        out.print("</HTML>");
        out.close();


    }

}
