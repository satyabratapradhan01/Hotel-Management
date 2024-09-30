package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    	
    	 String hotelPlace = request.getParameter("place");
         HttpSession session = request.getSession();
         session.setAttribute("place", hotelPlace);  // Store value in session
         
         // Redirect to the next JSP page
         response.sendRedirect("newhome2.jsp");
    	
//        String place = request.getParameter("place");      
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        try {         
//            Class.forName("com.mysql.cj.jdbc.Driver");          
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", "root", "1234");           
//            String sql = "INSERT INTO place (place) VALUES (?)";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, place);           
//            int rowsInserted = statement.executeUpdate();         
//            if (rowsInserted > 0) {
//              // out.println("<h1>Booking successful for " + place + "!</h1>");
//            	RequestDispatcher rd = request.getRequestDispatcher("/newhome2.jsp");
//            	rd.include(request, response);
//            } else {
//                out.println("<h1>Failed to book " + place + ". Please try again.</h1>");
//            }          
//            statement.close();
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            out.println("<h1>Error: " + e.getMessage() + "</h1>");
//        }
    }
}
