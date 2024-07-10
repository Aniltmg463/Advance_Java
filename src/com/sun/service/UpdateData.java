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
 * Servlet implementation class UpdateData
 */
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateData() {
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
		
		String email = request.getParameter("Email");
		String course = request.getParameter("course");
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String parent = request.getParameter("parent");
		String gender = request.getParameter("gender");
		String dateOfBirth = request.getParameter("dob");
		String joinDate = request.getParameter("joinDate");
		String nationality = request.getParameter("nationality");
		String pAddress = request.getParameter("pAddress");
	
		String contact = request.getParameter("contact");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
	
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/crudoperation","root","123");
			String sql = "UPDATE tb_record SET Course = ?, First_Name = ?, Last_Name = ?, Parent = ?, Gender = ?, Date_of_Birth = ?, Join_Date = ?, Nationality = ?, Permanent_Address = ?, Contact = ? WHERE Email = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, course);
			statement.setString(2, firstname);
			statement.setString(3, lastname);
			statement.setString(4, parent);
			statement.setString(5, gender);
			statement.setString(6, dateOfBirth);
			statement.setString(7, joinDate);
			statement.setString(8, nationality);
			statement.setString(9, pAddress);
			statement.setString(10, contact);
			statement.setString(11, email);
			
			int rowsUpdated = statement.executeUpdate();
			
			if (rowsUpdated > 0) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Your data has been updated');");
				out.println("location='searchData.jsp';");
				out.println("</script>");
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('No record found with the provided email');");
				out.println("location='searchData.jsp';");
				out.println("</script>");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
