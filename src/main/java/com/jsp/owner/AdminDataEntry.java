package com.jsp.owner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class AdminDataEntry extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String myName = req.getParameter("adminName");
        String myUsername = req.getParameter("adminUsername");
        String myPassword = req.getParameter("adminPassword");

        Connection con = null;
        PreparedStatement ps = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to the database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", "root", "1234");

            // Prepare SQL statement
            ps = con.prepareStatement("INSERT INTO admins (adminName, username, password) VALUES (?, ?, ?)");
            ps.setString(1, myName);
            ps.setString(2, myUsername);
            ps.setString(3, myPassword);

            int count = ps.executeUpdate();
            resp.setContentType("text/html");

            if (count > 0) {
                out.print("<h3>User Registered Successfully</h3>");
            } else {
                out.print("<h3>User not Registered due to some error</h3>");
            }

            // Redirect back to the signup page
//            RequestDispatcher rd = req.getRequestDispatcher("/.html");
//            rd.include(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            resp.setContentType("text/html");
            out.print("<h3>Exception Occurred: " + e.getMessage() + "</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("/signup.html");
            rd.include(req, resp);

        } finally {
            // Close resources
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
