package com.jsp.admin;

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

@WebServlet("/editurl")
public class CustomerEditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html");

        // Get parameters from the request
        int id = Integer.parseInt(req.getParameter("id"));
        String customerName = req.getParameter("CustomerName");
        String emailAddress = req.getParameter("EmailAddress");
        String phoneNumber = req.getParameter("PhoneNumber");
        String idProofType = req.getParameter("IDProofType");
        String idNumber = req.getParameter("IDNumber");
        String checkInDate = req.getParameter("CheckInDate");
        String checkInTime = req.getParameter("CheckInTime");
        String checkOutDate = req.getParameter("CheckOutDate");
        String checkOutTime = req.getParameter("CheckOutTime");
        String place = req.getParameter("Place");
        String roomType = req.getParameter("RoomType");
        String username = req.getParameter("UserName");
        String status = req.getParameter("Status");

        try {
            // Load MySQL driver and establish connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", "root", "1234");

            // SQL query to update customer details
            String query = "UPDATE checkinandcheckout SET Customer_Name = ?, Email_Address = ?, Phone_Number = ?, ID_Proof_Type = ?, ID_Number = ?, Check_In_Date = ?, Check_In_Time = ?, Check_Out_Date = ?, Check_Out_Time = ?, place = ?, room_type = ?, username = ?, status = ? WHERE SL_NO = ?";
            
            PreparedStatement ps = con.prepareStatement(query);
            
            // Set parameters for the prepared statement
            ps.setString(1, customerName);
            ps.setString(2, emailAddress);
            ps.setString(3, phoneNumber);
            ps.setString(4, idProofType);
            ps.setString(5, idNumber);
            ps.setString(6, checkInDate);
            ps.setString(7, checkInTime);
            ps.setString(8, checkOutDate);
            ps.setString(9, checkOutTime);
            ps.setString(10, place);
            ps.setString(11, roomType);
            ps.setString(12, username);
            ps.setString(13, status);
            ps.setInt(14, id); // SL_NO

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
