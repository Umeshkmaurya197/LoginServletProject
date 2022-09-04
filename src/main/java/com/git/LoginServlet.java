package com.git;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(description = "Login Servlet Testing", urlPatterns = {"/LoginServlet"}, initParams = {@WebInitParam(name = "user", value = "omi"), @WebInitParam(name = "password", value = "pwd")})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get request parameters for userId and password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        //get servlet config init params
        String userId = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");

        if (userId.equals(user) && password.equals(pwd)) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>User name or password is matched .</font>");
            rd.include(request, response);
        }
    }
}
