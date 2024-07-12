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

public class Deletesuccess extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Deletesuccess() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            // Capture the Contact parameter from the request
            String email = request.getParameter("email");

            // Ensure Contact is not null or empty
            if (email != null && !email.isEmpty()) {
                // Load the JDBC driver
                Class.forName("com.mysql.jdbc.Driver");
                
                // Establish connection to the database
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db_crud", "root", "123");
                Statement stm = con.createStatement();
                
                // SQL query to delete a record by Contact
                String deleteQuery = "DELETE FROM std_registration WHERE Email = '" + email + "'";
                
                // Execute the delete query
                int rowsAffected = stm.executeUpdate(deleteQuery);
                
                if (rowsAffected > 0) {
                    // Forward to success page if the deletion was successful
                    RequestDispatcher rd = request.getRequestDispatcher("success_delete.jsp");
                    rd.forward(request, response);
                } else {
                    // If no rows were deleted, it means the Contact was not found
                    out.println("<html><body><h3>No record found with Contact: " + email + "</h3></body></html>");
                }

                // Close resources
                stm.close();
                con.close();
            } else {
                // Handle the case where the Contact parameter is missing
                out.println("<html><body><h3>Error: Contact parameter is missing or empty.</h3></body></html>");
            }
        } catch (Exception e) {
            e.printStackTrace(out);
        } finally {
            out.close();
        }
    }
}
