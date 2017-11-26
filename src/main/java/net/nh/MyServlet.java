package net.nh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Simple, dumb dispatcher servlet, which dispatches located requests to a JSP with the same name in WEB-INF/jsp
 * directory.
 * <p>
 * For instance, if the user requests welcome.
 */
public class MyServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(MyServlet.class.getName());
    private static final Pattern JSP_PATTERN = Pattern.compile(".*/(\\w+)\\.do.*");
    private static final String JSP_DIRECTORY = "/WEB-INF/jsp/";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("Servlet received request for URI: {}", request.getRequestURI());
        RequestDispatcher dispatcher;
        String jspPath;

        Matcher matcher = JSP_PATTERN.matcher(request.getRequestURI());
        if (matcher.matches()) {
            jspPath = JSP_DIRECTORY + matcher.group(1) + ".jsp";
            if (getServletContext().getResource(jspPath) == null) {
                jspPath = JSP_DIRECTORY + "pageNotFound.jsp";
            }
        } else {
            jspPath = JSP_DIRECTORY + "pageNotFound.jsp";
        }

        dispatcher = request.getRequestDispatcher(jspPath);
        dispatcher.forward(request, response);
    }

}
