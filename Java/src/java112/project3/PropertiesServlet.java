package java112.project3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;
import java112.utilities.*;

/**
 *  Part of the mid-term exam
 *
 *@author    djcadd
 */
@WebServlet(
    name = "project3PropertiesServlet",
    urlPatterns = { "/project03-properties" }
)
public class PropertiesServlet extends HttpServlet {

    Properties properties = new Properties();

    public void loadProperties(String propertiesFilePath) {
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    public void init() {

        loadProperties("/project3.properties");

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

            // Add properties reference to the request object
            request.setAttribute("properties", properties);

            String url = "/project03-properties.jsp";

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
    }
}
