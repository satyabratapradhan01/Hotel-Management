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

@WebServlet("/Userediturl")
public class UserEditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html");

        // Get parameters from the request
        int id = Integer.parseInt(req.getParameter("id"));
        String customerName = req.getParameter("CustomerName");
        String phoneNumber = req.getParameter("PhoneNumber");
        String emailAddress = req.getParameter("EmailAddress");
        String Password = req.getParameter("Password");
        
        
        String username = req.getParameter("UserName");
        

        try {
            // Load MySQL driver and establish connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", "root", "1234");

            // SQL query to update customer details
            String query = "UPDATE customer SET coutomer_name = ?, coutomer_phnone_num = ?, email = ?, password = ?, username = ? WHERE coutomer_id = ?";
            
            PreparedStatement ps = con.prepareStatement(query);
            
            // Set parameters for the prepared statement
            ps.setString(1, customerName);
            ps.setString(2, phoneNumber);
            ps.setString(3, emailAddress);
            ps.setString(4, Password);
            ps.setString(5, username);            
            ps.setInt(6, id); // SL_NO

            // Execute the update
            int count = ps.executeUpdate();

            if (count == 1) {
                pw.println("<h2>Record is Edited Successfully</h2>");
            } else {
                pw.println("<h2>Record was not Edited Successfully</h2>");
            }

            pw.println("<a href='adminDashboard.jsp'>Admin Dashboard</a>");
            pw.println("<br>");
            pw.println("<a href='newhome.html'>Home</a>");

            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            pw.println("<h1>" + e.getMessage() + "</h1>");
        }
    }
}

