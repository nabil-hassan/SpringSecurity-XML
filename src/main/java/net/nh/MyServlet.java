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

public class MyServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(MyServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("In servlet");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/yan.jsp");
        dispatcher.forward(request, response);
    }

}
