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

@WebServlet("/signup")
public class Custsignup extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String myName = req.getParameter("name");
        String myEmail = req.getParameter("Email");
        String myphoneNo = req.getParameter("phoneno");
        String myAdhaar = req.getParameter("adhaar");
        String myUsername = req.getParameter("username");
        String myPassword = req.getParameter("password");
        Connection con = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", "root", "1234");

            ps = con.prepareStatement("insert into customer(coutomer_aadhar_num, coutomer_name, coutomer_phnone_num, email, password, username) values(?,?,?,?,?,?)");
            ps.setString(1, myAdhaar);
            ps.setString(2, myName);
            ps.setString(3, myphoneNo);
            ps.setString(4, myEmail);
            ps.setString(5, myPassword);
            ps.setString(6, myUsername);

            int count = ps.executeUpdate();
            resp.setContentType("text/html");

            if (count > 0) {
//                out.print("<h3>User Registered Successfully</h3>");
            	RequestDispatcher rd = req.getRequestDispatcher("/CustomerLogin.jsp");
        		rd.include(req, resp);
            } else {
                out.print("<h3>User not Registered due to some error</h3>");
            }

            RequestDispatcher rd = req.getRequestDispatcher("/signup.html");
            rd.include(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setContentType("text/html");
            out.print("<h3>Exception Occurred: " + e.getMessage() + "</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("/signup.html");
            rd.include(req, resp);
        } 
        }
}


