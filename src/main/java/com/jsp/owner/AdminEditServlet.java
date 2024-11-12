package com.jsp.owner;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminediturl")
public class AdminEditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html");

        // Get parameters from the request
        int id = Integer.parseInt(req.getParameter("id"));
        String AdminName = req.getParameter("AdminName");
        String AdminUserName = req.getParameter("AdminUserName");
        String Password = req.getParameter("Password");
        

        try {
            // Load MySQL driver and establish connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", "root", "1234");

            // SQL query to update customer details
            String query = "UPDATE admins SET adminName = ?, username = ?, password = ?  WHERE id = ?";
            
            PreparedStatement ps = con.prepareStatement(query);
            
            // Set parameters for the prepared statement
            ps.setString(1, AdminName);
            ps.setString(2, AdminUserName);
            ps.setString(3, Password);
            ps.setInt(4, id); // SL_NO

            // Execute the update
            int count = ps.executeUpdate();

            if (count == 1) {
                pw.println("<h2>Record is Edited Successfully</h2>");
            } else {
                pw.println("<h2>Record was not Edited Successfully</h2>");
            }

            pw.println("<a href='user'>Home</a>");
            pw.println("<br>");
            pw.println("<a href='booklist'>Book List</a>");

            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            pw.println("<h1>" + e.getMessage() + "</h1>");
        }
    }
}

