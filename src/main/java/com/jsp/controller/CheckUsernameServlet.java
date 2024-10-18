package com.jsp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/checkUsername")
public class CheckUsernameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        try {
            // Connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", "root", "1234");

            // Prepare the SQL query to check the username
            String sql = "SELECT * FROM checkinandcheckout WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // If the username exists, redirect to the dashboard
                req.setAttribute("username", username);
                RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
                rd.forward(req, resp);
            } else {
                // If the username does not exist, show an error message
                req.setAttribute("errorMessage", "Invalid username. Please try again.");
                RequestDispatcher rd = req.getRequestDispatcher("usernameEntry.jsp");
                rd.forward(req, resp);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "Error checking the username. Please try again.");
            RequestDispatcher rd = req.getRequestDispatcher("usernameEntry.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); // Forward GET requests to the doPost method
    }
}
