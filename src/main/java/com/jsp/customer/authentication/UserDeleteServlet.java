package com.jsp.customer.authentication;


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

@WebServlet("/UserdeleteScrene")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html");

        int id = Integer.parseInt(req.getParameter("id"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", "root", "1234");

            String query = "DELETE FROM customer WHERE coutomer_id = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            int count = ps.executeUpdate();

            if (count == 1) {
                pw.println("<h2>Record deleted successfully</h2>");
            } else {
                pw.println("<h2>Record deletion failed</h2>");
            }

            pw.println("<a href='adminDashboard.jsp'>Admin Dashboard</a>");
            pw.println("<br>");
            pw.println("<a href='newhome.html'>Home</a>"); // Redirect back to list

            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            pw.println("<h1>" + e.getMessage() + "</h1>");
        }
    }
}
