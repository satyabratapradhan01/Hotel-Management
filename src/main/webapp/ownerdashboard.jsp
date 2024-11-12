<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel Management Owner Dashboard</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            background-color: #1a237e;
            min-height: 100vh;
            padding: 20px;
            display: flex;
            flex-direction: column;
        }
          a {
            text-decoration: none;
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 20px;
            color: white;
            margin-bottom: 40px;
        }

        .header h1 {
            font-size: 24px;
            font-weight: 500;
        }

        .home-link {
            color: white;
            text-decoration: none;
            font-size: 16px;
        }

        .button-container {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 30px;
            max-width: 1000px;
            margin: 40px auto;
            padding: 20px;
        }

        .dashboard-button {
            position: relative;
            min-height: 200px;
            padding: 30px;
            border: none;
            border-radius: 15px;
            background: white;
            cursor: pointer;
            overflow: hidden;
            transition: all 0.3s ease;
            text-align: center;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .dashboard-button:hover {
            transform: translateY(-5px);
            box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2);
        }

        .dashboard-button::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            height: 4px;
        }

        .add-admin::before {
            background-color: #ff5722;
        }

        .admin-login::before {
            background-color: #2196f3;
        }

        .user-login::before {
            background-color: #4CAF50;
        }

        .checkin::before {
            background-color: #9c27b0;
        }

        .button-icon {
            font-size: 40px;
            margin-bottom: 15px;
            color: #333;
        }

        .button-text {
            font-size: 18px;
            color: #333;
            font-weight: 500;
            margin-bottom: 10px;
        }

        .button-description {
            font-size: 14px;
            color: #666;
            max-width: 200px;
            line-height: 1.4;
        }

        @media (max-width: 768px) {
            .button-container {
                grid-template-columns: 1fr;
            }

            .dashboard-button {
                min-height: 150px;
            }
        }
    </style>
</head>
<body>
    <header class="header">
        <h1>Hotel Management Owner Dashboard</h1>
        <a href="#" class="home-link">Home</a>
    </header>

    <div class="button-container">
        <!-- Add Admin Button -->
        <a href="adminentryform.jsp">
        <button class="dashboard-button add-admin">
            <div class="button-icon">👤</div>
            <div class="button-text">Add Admin</div>
            <div class="button-description">Create new admin accounts and manage permissions</div>
        </button>
        </a>

        <!-- Admin Login Details Button -->
        <a href="adminlist">
        <button class="dashboard-button admin-login">
            <div class="button-icon">🔐</div>
            <div class="button-text">Admin Login Details</div>
            <div class="button-description">View and monitor admin login activities</div>
        </button>
        
        <!-- User Login Details Button -->
           <a href="userRgis">
        <button class="dashboard-button user-login">
            <div class="button-icon">👥</div>
            <div class="button-text">User Login Details</div>
            <div class="button-description">Track guest login information and activities</div>
        </button>
        </a>

        <!-- Check-in Details Button -->
        <a href="user">
        <button class="dashboard-button checkin">
            <div class="button-icon">📝</div>
            <div class="button-text">Check-in Details</div>
            <div class="button-description">Manage guest check-ins and reservations</div>
        </button>
        </a>
    </div>
</body>
</html>