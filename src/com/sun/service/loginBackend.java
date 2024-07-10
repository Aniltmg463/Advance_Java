package com.sun.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginBackend
 */
public class loginBackend extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginBackend() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests if needed
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            String userid = request.getParameter("username");
            String password = request.getParameter("password");

            if (userid == null || password == null || userid.isEmpty() || password.isEmpty()) {
                out.println("Username or Password cannot be empty");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.include(request, response);
                return;
            }

            Class.forName("com.mysql.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost/crudOperation";
            String dbUser = "root";
            String dbPassword = "123";

            	Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                 PreparedStatement pstmt = con.prepareStatement("SELECT Username, Password FROM tb_register_data WHERE Username = ? AND Password = ?");

                pstmt.setString(1, userid);
                pstmt.setString(2, password);

                 ResultSet rs = pstmt.executeQuery();
                
                    if (rs.next()) {
                        RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                        rd.forward(request, response);
                    } else {
                        out.println("You have entered wrong data");
                        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                        rd.include(request, response);
                    }
               
            }
         catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
