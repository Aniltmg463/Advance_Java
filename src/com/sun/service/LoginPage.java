package com.sun.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;
/**
 * Servlet implementation class LoginPage
 */
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        Connection con = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;

	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/db_crud", "root", "123");

	            String sql = "SELECT * FROM tb_register WHERE username = ? AND password = ?";
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, username);
	            pstmt.setString(2, password);

	            rs = pstmt.executeQuery();

	            if (rs.next()) {
//	            	 String fname = rs.getString("first name");
//	                 String lname = rs.getString("Last Name");
//	                 String email = rs.getString("Email");
//
//	                 // Set user information in session
//	                 HttpSession session = request.getSession();
//	                 session.setAttribute("username", username);
//	                 session.setAttribute("fname", fname);
//	                 session.setAttribute("lname", lname);
//	                 session.setAttribute("email", email);
	                 
	                // If a matching record is found, handle the login success
	                response.sendRedirect("homepage.jsp"); // Replace with your success page
	            } else {
	                // If no matching record is found, handle the login failure
	                response.sendRedirect("Login.jsp?error=Invalid credentials"); // Replace with your login page
	            }
	        } catch (Exception e) {
	            e.printStackTrace(); // Handle errors appropriately (logging, error page, etc.)
	            response.sendRedirect("Login.jsp?error=Database connection error"); // Redirect to error page
	        } finally {
	            try {
	                if (rs != null) {
	                    rs.close();
	                }
	                if (pstmt != null) {
	                    pstmt.close();
	                }
	                if (con != null) {
	                    con.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace(); // Log or handle the exception
	            }
	        }
	}

}
