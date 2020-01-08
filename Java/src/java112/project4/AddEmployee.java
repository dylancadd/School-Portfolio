package java112.project4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;
import java112.employee.*;

/**
 *  Sends to data off to be analyzed and redirects user to html form
 *
 *@author    djcadd
 */
@WebServlet(
    name = "addEmployee",
    urlPatterns = { "/add-employee" }
)
public class AddEmployee extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            // Grabs all the values from the html form
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String ssn = request.getParameter("ssn");
            String dept = request.getParameter("dept");
            String room = request.getParameter("room");
            String phone = request.getParameter("phone");

            ServletContext context = getServletConfig().getServletContext();
            Object object = context.getAttribute("directory");

            EmployeeDirectory directory = (EmployeeDirectory) object;
            directory.addNewEmployee(firstName, lastName, ssn, dept, room, phone);

            HttpSession session = request.getSession();
            session.setAttribute("project4AddMessage", "Employee Added");

            String url = "/java112/forward-add";
            response.sendRedirect(url);
    }
}
