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
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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
			String firstname = request.getParameter("fname");
			String lastname = request.getParameter("lname");
			String email = request.getParameter("email");
			String username = request.getParameter("uname");
			String password = request.getParameter("pass");
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crudOperation","root","123");
			Statement stm = con.createStatement();
			stm.executeUpdate("insert into tb_register_data values"+"('"+firstname+"','"+lastname+"','"+email+"','"+username+"','"+password+"')");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request,response);
			
		}
		catch(Exception e)
		{
			out.println("Error " + e);
			e.printStackTrace();
		}
	}

}
