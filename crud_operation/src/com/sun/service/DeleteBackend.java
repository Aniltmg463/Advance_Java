package com.sun.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteBackend
 */
public class DeleteBackend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBackend() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		 String email = request.getParameter("email");

	        Connection con = null;
	        PreparedStatement pstmt = null;

	        try {
	            // JDBC Database connection
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/crudoperation", "root", "123");

	            String sql = "DELETE FROM tb_record WHERE email = ?";
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, email);

	            int rowsDeleted = pstmt.executeUpdate();

	            if (rowsDeleted > 0) {
	            	out.println("<script type=\"text/javascript\">");
					out.println("alert('Your data has been deleted');");
					out.println("location='deleteData.jsp';");
					out.println("</script>");
	            } else {
	            	out.println("<script type=\"text/javascript\">");
					out.println("alert('You have inserted wrong data ');");
					out.println("location='deleteData.jsp';");
					out.println("</script>");
	            }
	        } catch (Exception e) {
	            e.printStackTrace(); // Handle errors appropriately (logging, error page, etc.)
	            response.sendRedirect("delete-fail.jsp?error=Database connection error"); // Redirect to error page
	        } finally {
	            try {
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
