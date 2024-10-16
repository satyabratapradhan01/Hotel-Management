<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jsp.controller.CheckinDetails" %> <!-- Import the CheckinDetails class -->

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        .container {
            width: 80%;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table th, table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }
        table th {
            background-color: #f4f4f4;
        }
        .no-data {
            text-align: center;
            color: red;
        }
    </style>
</head>
<body>
    <header>
        <div class="cloud"></div>
        <div class="cloud"></div>
    </header>

    <div class="container">
        <h2>Welcome, <%= session.getAttribute("username") %>!</h2>

        <table id="roomTable">
            <thead>
                <tr>
                    <th>Customer Name</th>
                    <th>Place</th>
                    <th>Room Type</th>
                    <th>Status</th>
                    <th>Check-In Date</th>
                    <th>Check-Out Date</th>
                </tr>
            </thead>
            <tbody>
                <% 
                // Get the check-in list from the request attribute
                List<CheckinDetails> checkinList = (List<CheckinDetails>) request.getAttribute("checkinList");

                if (checkinList == null || checkinList.isEmpty()) {
                %>
                    <tr>
                        <td colspan="6" class="no-data">No check-in data available for this user.</td>
                    </tr>
                <% 
                } else {
                    // Iterate over the list
                    for (CheckinDetails checkin : checkinList) { 
                %>
                    <tr>
                        <td><%= checkin.getCustomerName() %></td>
                        <td><%= checkin.getPlace() %></td>
                        <td><%= checkin.getRoomType() %></td>
                        <td><%= checkin.getStatus() %></td>
                        <td><%= checkin.getCheckInDate() %></td>
                        <td><%= checkin.getCheckOutDate() %></td>
                    </tr>
                <% 
                    } // end for
                } // end if
                %>
            </tbody>
        </table>
    </div>

    <script>
        // You can add any JavaScript here if needed for interaction or further styling
    </script>
</body>
</html>
