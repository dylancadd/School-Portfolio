package java112.project4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;

/**
 *  Forward to the Employee Add JSP Page
 *
 *@author    djcadd
 */
@WebServlet(
    name = "forwardAdd",
    urlPatterns = { "/forward-add" }
)
public class ForwardAdd extends HttpServlet {

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

            String url = "/project4-add-employee.jsp";

            RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

    }
}
