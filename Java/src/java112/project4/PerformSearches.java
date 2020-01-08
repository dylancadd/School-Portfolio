package java112.project4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;
import java112.employee.EmployeeDirectory;

/**
 *  Performs the search and adds the object to the session and forwards user to
 *  the JSP page to display the search
 *
 *@author    djcadd
 */
@WebServlet(
    name = "performSearch",
    urlPatterns = { "/perform-search" }
)
public class PerformSearches extends HttpServlet {

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

            ServletContext context = getServletConfig().getServletContext();
            Object object = context.getAttribute("directory");

            EmployeeDirectory directory = (EmployeeDirectory) object;

            String searchTerm = request.getParameter("searchTerm");
            String searchType = request.getParameter("searchType");


            HttpSession session = request.getSession();
            session.setAttribute("search_emp", directory.searchEmployee(searchTerm, searchType));

            String url = "/project4-display-results.jsp";

            RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

    }
}
