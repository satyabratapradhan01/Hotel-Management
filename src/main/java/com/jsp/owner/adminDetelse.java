package com.jsp.owner;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminlist")
public class adminDetelse extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", "root", "1234");

            String query = "SELECT * FROM admins";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            // Inline CSS styling
            pw.println("<style>");
            pw.println("body { font-family: Arial, sans-serif; }");
            pw.println("table { width: 90%; margin: 20px auto; border-collapse: collapse; font-size: 14px; }");
            pw.println("th, td { padding: 12px; text-align: center; border: 1px solid #ddd; }");
            pw.println("th { background-color: #4CAF50; color: white; }");
            pw.println("tr:nth-child(even) { background-color: #f2f2f2; }");
            pw.println("tr:hover { background-color: #ddd; }");
            pw.println("a { text-decoration: none; color: #4CAF50; font-weight: bold; }");
            pw.println("a:hover { color: #ff5722; }");
            pw.println(".center { text-align: center; }");
            pw.println("</style>");

            // HTML Table with CSS styling
            pw.println("<table>");
            pw.println("<tr>");
            pw.println("<th>Sl No</th>");
            pw.println("<th>Admin Name</th>");
            pw.println("<th>Admin Username</th>");
            pw.println("<th>Password</th>");
            pw.println("<th>EDIT</th>");
            pw.println("<th>DELETE</th>");
            pw.println("</tr>");

            while (rs.next()) {
                int id = rs.getInt("id"); 
                pw.println("<tr>");
                pw.println("<td>" + id + "</td>");
                pw.println("<td>" + rs.getString("adminName") + "</td>");
                pw.println("<td>" + rs.getString("username") + "</td>");
                pw.println("<td>" + rs.getString("password") + "</td>"); 
       
               
                pw.println("<td><a href='ownerediteScrene?id=" + id + "'>EDIT</a></td>");
                
                // Use a form to submit the delete request via POST
                pw.println("<td>");
                pw.println("<form action='admindeleteScrene' method='post'>");
                pw.println("<input type='hidden' name='id' value='" + id + "'>");
                pw.println("<button type='submit'>DELETE</button>");
                pw.println("</form>");
                pw.println("</td>");
                
                pw.println("</tr>");
            }

            pw.println("</table>");
            pw.println("<div class='center'>");
            pw.println("<a href='shop.html'>Home</a>");
            pw.println("</div>");

            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            pw.println("<h1 style='color: red; text-align: center;'>" + e.getMessage() + "</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Forward the POST request to the doGet method
        doGet(req, resp);
    }
}

