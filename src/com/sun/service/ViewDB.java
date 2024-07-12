package com.sun.service;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.model.Registration;

/**
 * Servlet implementation class ViewDB
 */
public class ViewDB extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDB() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Call doPost for this example, or redirect to doPost for a common logic
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // JDBC URL, username, and password of MySQL server
        String jdbcURL = "jdbc:mysql://localhost:3306/db_crud";
        String dbUser = "root";
        String dbPassword = "123";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Establish connection to MySQL database
            connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            // Execute SQL query to retrieve all data from your table
            String sql = "SELECT * FROM std_registration";
            preparedStatement = connection.prepareStatement(sql);
            
            
  //          preparedStatement = conn.Statement();
//            rs = stmt.executeQuery(sql);

            // Display data in HTML table format
//            out.println("<html><head><title>Data from Database</title></head><body>");
//            out.println("<h2>Data from Database</h2>");
//            out.println("<table border='1'>");
//            out.println("<tr><th>Course Offered</th><th>First Name</th><th>Last Name</th>"
//                    + "<th>Parent Name</th><th>Gender</th><th>DOB</th><th>Join Date</th><th>Nationality</th>"
//                    + "<th>Address</th><th>Email</th><th>Contact</th></tr>");
//
//            while (rs.next()) {
//                String courseOffered = rs.getString("Courses");
//                String firstname = rs.getString("Firstname");
//                String lastname = rs.getString("Lastname");
//                String parentName = rs.getString("Parent_Name");
//                String gender = rs.getString("Gender");
//                String dob = rs.getString("DOB");
//                String joinDate = rs.getString("Join_date");
//                String nationality = rs.getString("Nationality");
//                String address = rs.getString("Address");
//                String email = rs.getString("Email");
//                String contact = rs.getString("Contact");
//
//                out.println("<tr>");
//                out.println("<td>" + courseOffered + "</td>");
//                out.println("<td>" + firstname + "</td>");
//                out.println("<td>" + lastname + "</td>");
//                out.println("<td>" + parentName + "</td>");
//                out.println("<td>" + gender + "</td>");
//                out.println("<td>" + dob + "</td>");
//                out.println("<td>" + joinDate + "</td>");
//                out.println("<td>" + nationality + "</td>");
//                out.println("<td>" + address + "</td>");
//                out.println("<td>" + email + "</td>");
//                out.println("<td>" + contact + "</td>");
//                out.println("</tr>");
//            }
//            out.println("<a href='homepage.jsp' class = 'button'>Home</a>");
//            out.println("</table></body></html>");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            out.println("Error: " + e.getMessage());
//        } finally {
//            // Close all resources
//            try {
//                if (rs != null) rs.close();
//                if (stmt != null) stmt.close();
//                if (conn != null) conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
            
            
            List<Registration> resultList = new ArrayList<Registration>();
            resultSet = preparedStatement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
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
            }
            request.setAttribute("Result", resultList);
            RequestDispatcher rd = request.getRequestDispatcher("viewAllData.jsp");
            rd.forward(request, response);

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
