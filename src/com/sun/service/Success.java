package com.sun.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Success
 */
public class Success extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Success() {
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
		try
		{
			String Course = request.getParameter("courseOffered");
			String firstname = request.getParameter("fname");
			String lastname = request.getParameter("lname");
			String pname = request.getParameter("parentName");
			String Gender = request.getParameter("gender");
			String DOB = request.getParameter("dob");
			String JoinDate = request.getParameter("joinDate");
			String Nationality = request.getParameter("nationality");
			String Address = request.getParameter("address");
			String Email = request.getParameter("email");
			String Contact = request.getParameter("contact");
		
	
			
			Class.forName ("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db_crud", "root", "123");
			Statement stm = con.createStatement();
			stm.executeUpdate
			("insert into std_registration values" + "('"+Course+"', '"+firstname+"', '"+lastname+"', '"+pname+"', " +
					"'"+Gender+"', '"+DOB+"', '"+JoinDate+"', '"+Nationality+"', '"+Address+"', '"+Email+"', '"+Contact+"')");
			
			RequestDispatcher rd = request.getRequestDispatcher("success_std_reg.jsp");
            rd.forward(request, response);

            stm.close();
            con.close();
		}
		catch (Exception e)
		{
			System.out.print("Error" +e);
			e.printStackTrace();
		}
	}

}
