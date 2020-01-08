package java112.project3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;

/**
 *  This is part of a lab and is the first servlet for the course.
 *
 *@author    djcadd
 */
@WebServlet(
    name = "lab33Servlet",
    urlPatterns = { "/lab33" }
)
public class Lab33Servlet extends HttpServlet {

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

            Map map = new HashMap();

            map.put("number", 3);
            map.put("text", "Avengers. Assemble.");
            map.put("html", "<h2>Reality is often disappointing</h2>");
            map.put("aDate", new Date());

            request.setAttribute("myMap", map);

            String url = "/lab33.jsp";

            RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

    }
}
