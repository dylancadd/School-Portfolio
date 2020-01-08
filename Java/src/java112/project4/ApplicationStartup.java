package java112.project4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;
import java112.employee.*;
import java112.utilities.*;

/**
 *  Application startup
 *
 *@author    djcadd
 */
@WebServlet(
    name = "applicationStartup",
    urlPatterns = { "/project4-startup" },
    loadOnStartup = 1
)
public class ApplicationStartup extends HttpServlet implements PropertiesLoader {

    public void init() {
        // Load the project4.properties
        Properties properties = loadProperties("/project4.properties");

        // Place the properties into the ServletContext
        ServletContext context = getServletConfig().getServletContext();
        context.setAttribute("prop", properties);

        // Create instance
        EmployeeDirectory directory = new EmployeeDirectory(properties);

        // Place dir into the ServletContext
        context.setAttribute("directory", directory);
    }

}
