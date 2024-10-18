package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Search")

public class ServlateDashboard extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String myUsername = request.getParameter("username");

      out.println("<!DOCTYPE html>");
      out.println("<html lang='en'>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
      out.println("<title>User Dashboard</title>");
      out.println("<style>");
      out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }");
      
      // Updated nav bar color
      out.println("nav { background-color: #007BFF; padding: 10px; position: sticky; top: 0; width: 119.5%; z-index: 1000; }");
      out.println("nav a { color: white; text-decoration: none; padding: 14px 20px; display: inline-block; font-size: 18px; }");
      out.println("nav a:hover { background-color: #0056b3; }"); // Darker blue on hover
      
      out.println("table { width: 100%; border-collapse: collapse; background-color: white; margin-top: 20px; box-shadow: 0 1px 3px rgba(0,0,0,0.2); }");
      out.println("caption { font-size: 1.5em; margin-bottom: 10px; font-weight: bold; color: #333; }");
      out.println("th, td { padding: 12px; text-align: left; border-bottom: 1px solid #ddd; }");
      out.println("th { background-color: #4CAF50; color: white; }");
      out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
      out.println("tr:hover { background-color: #ddd; }");
      out.println(".error { color: red; background-color: #ffe6e6; padding: 10px; border: 1px solid #ff9999; border-radius: 4px; }");
      out.println("</style>");
      out.println("</head>");
      out.println("<body>");

      // Top Navigation Bar
      out.println("<nav>");
      out.println("<a href='newhome.html'>Home</a>");
      out.println("</nav>");

      try {
          // Load the MySQL JDBC driver
          Class.forName("com.mysql.jdbc.Driver");

          // Establish connection to the database
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", "root", "1234");

          // Prepare the SQL query to check the username
          String sql = "SELECT * FROM checkinandcheckout WHERE username = ?";
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setString(1, myUsername);

          // Execute query
          ResultSet rs = ps.executeQuery();
          ResultSetMetaData rsmd = rs.getMetaData();
          int totalColumn = rsmd.getColumnCount();

          out.println("<table>");
          out.println("<caption>User Dashboard</caption>");

          // Display column names
          out.println("<tr>");
          for (int i = 1; i <= totalColumn; i++) {
              out.println("<th>" + rsmd.getColumnName(i) + "</th>");
          }
          out.println("</tr>");

          // Check if there are any results
          if (!rs.isBeforeFirst()) {
              out.println("<tr><td colspan='" + totalColumn + "'>No data found for the given username.</td></tr>");
          } else {
              // Print user data rows
              while (rs.next()) {
                  out.println("<tr>");
                  for (int i = 1; i <= totalColumn; i++) {
                      String columnValue = rs.getString(i);
                      // Handle null values by printing an empty string instead
                      if (columnValue == null) {
                          columnValue = "N/A";
                      }
                      out.println("<td>" + columnValue + "</td>");
                  }
                  out.println("</tr>");
              }
          }
          out.println("</table>");

          // Close the connection
          con.close();
      } catch (Exception e) {
          out.println("<p class='error'>Error: " + e.getMessage() + "</p>");
      }

      out.println("</body>");
      out.println("</html>");
  }
}
