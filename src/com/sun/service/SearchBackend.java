package com.sun.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchBackend
 */
public class SearchBackend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBackend() {
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
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
	
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/crudoperation","root","123");
			String sql = "select * from tb_record where Email = ?" ;
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet result = statement.executeQuery(); 
			if(result.next())
			{
			
				
				String course = result.getString("Course");;
				String firstname = result.getString("First_Name");
				String lastname = result.getString("Last_Name");
				String parent = result.getString("Parent");
				String gender = result.getString("Gender");
				String dateBirth = result.getString("Date_of_Birth");
				String joinDate = result.getString("Join_Date");
				String Nationality =result.getString("Nationality");
				String pAddress =result.getString("Permanent_Address");
				String eemail = result.getString("Email");
				String contact =result.getString("Contact");
				
				request.setAttribute("course", course);
				request.setAttribute("fname", firstname);
				request.setAttribute("lname", lastname);
				request.setAttribute("parent", parent);
				request.setAttribute("gender", gender);
				request.setAttribute("dob", dateBirth);
				request.setAttribute("jdate", joinDate);
				request.setAttribute("nationality", Nationality);
				request.setAttribute("paddress", pAddress);
				request.setAttribute("email", eemail);
				request.setAttribute("contact", contact);
				RequestDispatcher rd = request.getRequestDispatcher("showData.jsp");
				rd.forward(request, response);
				
			}
			else
			{
				
				  out.println("<script type=\"text/javascript\">");
				    out.println("alert('Email not found');");
				    out.println("location='searchData.jsp';");
				    out.println("</script>");
				//response.sendRedirect("searchData.jsp");
				
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
