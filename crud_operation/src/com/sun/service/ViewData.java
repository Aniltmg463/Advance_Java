package com.sun.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.model.Record;

/**
 * Servlet implementation class ViewData
 */
public class ViewData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewData() {
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
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
	
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/crudoperation","root","123");
			String sql = "select * from tb_record" ;
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet result = statement.executeQuery(); 
			  List<Record> recordlist = new ArrayList<Record>();

	            while (result.next()) {
	                Record record = new Record();
	                record.setCourse(result.getString("Course"));
	                record.setFirstname(result.getString("First_Name"));
	                record.setLastname(result.getString("Last_Name"));
	                record.setParent(result.getString("Parent"));
	                record.setGender(result.getString("Gender"));
	                record.setDateOfBirth(result.getString("Date_of_Birth"));
	                record.setJoinDate(result.getString("Join_Date"));
	                record.setNationality(result.getString("Nationality"));
	                record.setPermanentAddress(result.getString("Permanent_Address"));
	                record.setEmail(result.getString("Email"));
	                record.setContact(result.getString("Contact"));

	                recordlist.add(record);
	            }

	            request.setAttribute("Record", recordlist);
	            RequestDispatcher rd = request.getRequestDispatcher("viewData.jsp");
	            rd.forward(request, response);

			
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
