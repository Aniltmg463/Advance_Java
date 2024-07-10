 package com.sun.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registerBackend
 */
public class registerBackend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerBackend() {
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
		
		String course = request.getParameter("course");
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String parent = request.getParameter("parent");
		String gender = request.getParameter("gender");
		String dateOfBirth = request.getParameter("dob");
		String joinDate = request.getParameter("joinDate");
		String Nationality = request.getParameter("nationality");
		String pAddress = request.getParameter("pAddress");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		
		try{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/crudoperation","root","123");
		 PreparedStatement pstmt = null;
		 String sql = "INSERT into tb_record (`Course`, `First_Name`, `Last_Name`, `Parent`, `Gender`, `Date_of_Birth`, `Join_Date`, `Nationality`, `Permanent_Address`, `Email`, `Contact`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, course);
         pstmt.setString(2, firstname);
         pstmt.setString(3, lastname);
         pstmt.setString(4, parent);
         pstmt.setString(5, gender);
         pstmt.setString(6, dateOfBirth);
         pstmt.setString(7, joinDate);
         pstmt.setString(8, Nationality);
         pstmt.setString(9, pAddress);
         pstmt.setString(10, email);
         pstmt.setString(11, contact);
         
         int rows = pstmt.executeUpdate();
         if (rows > 0) {
            
        	 out.println("<script type=\"text/javascript\">");
			    out.println("alert('Data has been successfully inserted');");
			    out.println("location='home.jsp';");
			    out.println("</script>");
         } 
         else {
             out.println("<h1>Registration failed.</h1>");
         }

		
		}
		catch(Exception e)
		{
			out.println("Error " + e);
		}
	}

}
