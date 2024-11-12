package com.jsp.owner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.cj.xdevapi.PreparableStatement;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/ownerlogin")
public class OwnerLogin extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String myusername = req.getParameter("username");	
String mypass = req.getParameter("password");
PrintWriter out = resp.getWriter();
resp.setContentType("text/html");

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", "root", "1234");
	
	PreparedStatement ps = con.prepareStatement("select * from owner where username=? and password=?");
	ps.setString(1, myusername);
	ps.setString(2, mypass);
	
	ResultSet rs = ps.executeQuery();
	
	if(rs.next()) {
		// Login successful, store username in session
//        HttpSession session = req.getSession();
//        session.setAttribute("username", myusername);
//		out.print("admin page");
		
		RequestDispatcher rd = req.getRequestDispatcher("/ownerdashboard.jsp");
		rd.include(req, resp);
	}else {
		 req.setAttribute("errorMessage", "Incorrect user ID or password. Please try again.");
         req.getRequestDispatcher("owner.jsp").forward(req, resp);
//		out.print("<h3 style='color:red'> Email id and password didnot match</h3>");
//		RequestDispatcher rd = req.getRequestDispatcher("/CustomerLogin.jsp");
//		rd.include(req, resp);
	}
}catch(Exception e) {
	e.printStackTrace();
	
	out.print("<h3 style='color:red'>"+e.getMessage()+"</h3>");
	
	RequestDispatcher rd = req.getRequestDispatcher("/CustomerLogin.jsp");
	rd.include(req, resp);
}
}
}

