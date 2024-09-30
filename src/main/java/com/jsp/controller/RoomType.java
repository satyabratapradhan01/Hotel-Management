package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/roomtype")
public class RoomType extends HttpServlet {
    private static final long serialVersionUID = 1L;

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 String roomType = request.getParameter("roomtype");
         HttpSession session = request.getSession();
         session.setAttribute("roomtype", roomType);  // Store value in session
         
         // Redirect to the next JSP page
         response.sendRedirect("checkInCheckOut.jsp");
//        String myRoomType = request.getParameter("roomtype");
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", "root", "1234")) {
//                String sql = "INSERT INTO place (room_type) VALUES (?)";
//                try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                    statement.setString(1, myRoomType);
//                    int rowsInserted = statement.executeUpdate();
//                    if (rowsInserted > 0) {
//                        request.getRequestDispatcher("/checkInCheckOut.jsp").include(request, response);
//                    } else {
//                        out.println("<h1>Failed to add room type " + myRoomType + ". Please try again.</h1>");
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            out.println("<h1>Error: " + e.getMessage() + "</h1>");
//        }
    }
}
