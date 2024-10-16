package com.jsp.controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/dashboard")
public class dashboard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        if (username == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", "root", "1234");

            String sql = "SELECT Customer_Name, place, room_type,  status, Check_In_Date, Check_Out_Date FROM checkinandcheckout WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username); // Use the actual username from the session
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No results found for user: " + username);
            } else {
                // Reset the cursor back to the beginning of the ResultSet
                rs.beforeFirst();
            }


            List<CheckinDetails> checkinList = new ArrayList<>();

            while (rs.next()) {
                CheckinDetails details = new CheckinDetails();
                details.setCustomerName(rs.getString("Customer_Name"));
                details.setPlace(rs.getString("place"));
                details.setRoomType(rs.getString("room_type"));
                details.setStatus(rs.getString("status"));
                details.setCheckInDate(rs.getString("Check_In_Date"));
                details.setCheckOutDate(rs.getString("Check_Out_Date"));
              

                checkinList.add(details);
            }

            if (checkinList.isEmpty()) {
                System.out.println("No check-in data found for user: " + username);
            } else {
                System.out.println("Check-in data found: " + checkinList.size() + " records.");
            }

            req.setAttribute("checkinList", checkinList);
            RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
            rd.forward(req, resp);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
