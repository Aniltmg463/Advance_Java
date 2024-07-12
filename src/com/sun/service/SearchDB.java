package com.sun.service;



import com.sun.model.Registration;
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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class SearchDB
 */
public class SearchDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDB() {
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
		 String email = request.getParameter("email");
	        
		 PrintWriter out = response.getWriter();
	      	   

	   List<Registration> resultList = new ArrayList<Registration>();
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            // Load JDBC driver
	            Class.forName("com.mysql.jdbc.Driver");

	            // Connect to the database
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_crud", "root", "123");

	            // Prepare SQL query
	            String sql = "SELECT * FROM std_registration WHERE Email = ?";
	            preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, email);

	            // Execute the query
	            resultSet = preparedStatement.executeQuery();

	            // Process the result set
	            if (resultSet.next()) {
	                Registration reg = new Registration();
	                reg.setCourse(resultSet.getString("Courses"));
	                reg.setFname(resultSet.getString("Firstname"));
	                reg.setLname(resultSet.getString("Lastname"));
	                reg.setPname(resultSet.getString("Parent_Name"));
	                reg.setSex(resultSet.getString("Gender"));
	                reg.setDob(resultSet.getString("DOB"));
	                reg.setJoindate(resultSet.getString("Join_date"));
	                reg.setNationality(resultSet.getString("Nationality"));
	                reg.setAddress(resultSet.getString("Address"));
	                reg.setEmail(resultSet.getString("Email"));
	                reg.setContactno(resultSet.getString("Contact"));

	                // Add the object to the list
	                resultList.add(reg);
	                
	                request.setAttribute("Result", resultList);
		            RequestDispatcher rd = request.getRequestDispatcher("viewData.jsp");
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
	            e.printStackTrace();
	        } finally {
	            // Close resources
	            try {
	                if (resultSet != null) resultSet.close();
	                if (preparedStatement != null) preparedStatement.close();
	                if (connection != null) connection.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	       
   
	}

}
