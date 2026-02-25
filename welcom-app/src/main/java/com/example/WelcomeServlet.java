package com.example;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Welcome to My Web App!</h1>");
    }
}
