package com.jsp.owner;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ownerediteScrene")
public class AdminEditScreen extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html");

        int id = Integer.parseInt(req.getParameter("id")); // Fetch ID from request
        try {
            // Load MySQL driver and establish connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", "root", "1234");

            // SQL query to fetch details by ID
            String query = "SELECT username, password, adminName FROM admins WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            // Add inline CSS styling with color and border effects
            pw.println("<style>");
            pw.println("body { font-family: Arial, sans-serif; background-color: #f2f2f2; color: #333; }");
            pw.println("table { margin: 30px auto; border-collapse: collapse; width: 60%; background-color: #ffffff; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); }");
            pw.println("td { padding: 12px; border-bottom: 1px solid #ddd; }");
            pw.println("td:first-child { font-weight: bold; color: #555; }");
            pw.println("input[type='text'] { width: 100%; padding: 8px; margin: 5px 0; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }");
            pw.println("input[type='submit'], input[type='reset'] { padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer; font-size: 1em; }");
            pw.println("input[type='submit'] { background-color: #4CAF50; color: white; }");
            pw.println("input[type='reset'] { background-color: #f44336; color: white; }");
            pw.println("input[type='submit']:hover { background-color: #45a049; }");
            pw.println("input[type='reset']:hover { background-color: #d32f2f; }");
            pw.println("</style>");

            if (rs.next()) {
                // Generate an HTML form for editing details
                pw.println("<form action='adminediturl?id=" + id + "' method='post'>");
                pw.println("<table>");
                
                pw.println("<tr><td>Admin Name</td><td><input type='text' name='AdminName' value='" + rs.getString(3) + "'></td></tr>");
                pw.println("<tr><td>Admin UserName</td><td><input type='text' name='AdminUserName' value='" + rs.getString(1) + "'></td></tr>");
                pw.println("<tr><td>Password</td><td><input type='text' name='Password' value='" + rs.getString(2) + "'></td></tr>");
                
                
                pw.println("<tr><td colspan='2' style='text-align:center;'>");
                pw.println("<input type='submit' value='Edit'>");
                pw.println("<input type='reset' value='Cancel'>");
                pw.println("</td></tr>");
                
                pw.println("</table>");
                pw.println("</form>");
            } else {
                pw.println("<h1>No record found for the provided ID</h1>");
            }
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            pw.println("<h1 style='color: red; text-align: center;'>" + e.getMessage() + "</h1>");
        }
    }
}
