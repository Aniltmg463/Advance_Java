package com.sun.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Updatesuccess extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Updatesuccess() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            // Capture parameters from the request
            String course = request.getParameter("courseOffered");
            String firstname = request.getParameter("fname");
            String lastname = request.getParameter("lname");
            String parentName = request.getParameter("parentName");
            String gender = request.getParameter("gender");
            String dob = request.getParameter("dob");
            String joinDate = request.getParameter("joinDate");
            String nationality = request.getParameter("nationality");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String contact = request.getParameter("contact");

            // Ensure Contact is not null or empty
            if (email != null && !email.isEmpty()) {
                // Load the JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                // Establish connection to the database
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db_crud", "root", "123");

                // SQL query to update data based on Contact
                String updateQuery = "UPDATE std_registration SET Courses = ?, Firstname = ?, Lastname = ?, Parent_Name = ?, Gender = ?, DOB = ?, Join_date = ?, Nationality = ?, Address = ?, Contact = ? WHERE Email = ?";

                // Use PreparedStatement to set parameters and prevent SQL injection
                PreparedStatement ps = con.prepareStatement(updateQuery);
                ps.setString(1, course);
                ps.setString(2, firstname);
                ps.setString(3, lastname);
                ps.setString(4, parentName);
                ps.setString(5, gender);
                ps.setString(6, dob);
                ps.setString(7, joinDate);
                ps.setString(8, nationality);
                ps.setString(9, address);
                ps.setString(10, contact );
                ps.setString(11, email);

                // Execute the update query
                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    // Forward to success page if the update was successful
                    RequestDispatcher rd = request.getRequestDispatcher("success_update.jsp");
                    rd.forward(request, response);
                } else {
                    // If no rows were updated, it means the Contact was not found
                    out.println("<html><body><h3>No record found with Email: " + email + "</h3></body></html>");
                }

                // Close resources
                ps.close();
                con.close();
            } else {
                // Handle the case where the Contact parameter is missing
                out.println("<html><body><h3>Error: Email parameter is missing or empty.</h3></body></html>");
            }
        } catch (Exception e) {
            e.printStackTrace(out);
        } finally {
            out.close();
        }
    }
}
