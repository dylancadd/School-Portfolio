package java112.project3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;

/**
 *  Part of the mid-term exam
 *
 *@author    djcadd
 */
@WebServlet(
    name = "requestServlet",
    urlPatterns = { "/request-servlet" }
)
public class HttpRequestServlet extends HttpServlet {

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

            HttpRequestData data = new HttpRequestData();

            data.setRemoteComputer(request.getRemoteHost());
            data.setAddressRemoteComputer(request.getRemoteAddr());
            data.setHttpRequest(request.getScheme());
            data.setRequestUri(request.getRequestURI());
            data.setRequestUrl(request.getRequestURL());
            data.setProtocolRequest(request.getProtocol());
            data.setServerName(request.getServerName());
            data.setServerPort(request.getServerPort());
            data.setCurrentLocale(request.getLocale());
            data.setQueryString(request.getQueryString());
            data.setQueryParameter(request.getParameter("queryParameter"));
            data.setRequestHeader(request.getHeader("User-Agent"));

            request.setAttribute("bean", data);

            String url = "/project03.jsp";

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
    }
}
