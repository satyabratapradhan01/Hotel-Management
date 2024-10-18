package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkinandout")
public class CheckInAndOut extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
        PrintWriter out = resp.getWriter();
        String myCustomerName = req.getParameter("name");
        String myEmailAddress = req.getParameter("email");
        String myPhoneNumber = req.getParameter("phone");
        String myIDProof = req.getParameter("idType");
        String myIDNumber = req.getParameter("idNumber");
        String myCheckInDate = req.getParameter("checkInDate");
        String myCheckInTime = req.getParameter("checkInTime");
        String myCheckOutDate = req.getParameter("checkOutDate");
        String myCheckOutTime = req.getParameter("checkOutTime");
        
        // session import
        HttpSession session = req.getSession();
        String myPlace = (String) session.getAttribute("place");
        String myRoomType = (String) session.getAttribute("roomtype");
        String username = (String) session.getAttribute("username");

        
        
   

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", "root", "1234");

           PreparedStatement ps = con.prepareStatement("INSERT INTO checkinandcheckout(Customer_Name, Email_Address, Phone_Number, ID_Proof_Type, ID_Number, Check_In_Date, Check_In_Time, Check_Out_Date, Check_Out_Time, place, room_type, username) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, myCustomerName);
            ps.setString(2, myEmailAddress);
            ps.setString(3, myPhoneNumber);
            ps.setString(4, myIDProof);
            ps.setString(5, myIDNumber);
            ps.setString(6, myCheckInDate);
            ps.setString(7, myCheckInTime);
            ps.setString(8, myCheckOutDate);
            ps.setString(9, myCheckOutTime);
            ps.setString(10, myPlace);
            ps.setString(11, myRoomType);
            ps.setString(12, username);
            

            int count = ps.executeUpdate();
            resp.setContentType("text/html");

            if (count > 0) {
                RequestDispatcher rd = req.getRequestDispatcher("/checkInSuccessfully.jsp");
                rd.include(req, resp);
            } else {
                out.print("<h3>User not Registered due to some error</h3>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.setContentType("text/html");
            out.print("<h3>Exception Occurred: " + e.getMessage() + "</h3>");
//            RequestDispatcher rd = req.getRequestDispatcher("/signup.html");
//            rd.include(req, resp);
        }
    }
}


