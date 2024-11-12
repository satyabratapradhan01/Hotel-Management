<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Hotel Management Admin Dashboard</title>
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

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 20px;
            color: white;
            margin-bottom: 40px;
        }
        
        a {
            text-decoration: none;
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
            display: flex;
            gap: 30px;
            max-width: 800px;
            margin: 40px auto;
            padding: 20px;
            justify-content: center;
        }

        .dashboard-button {
            position: relative;
            width: 300px;
            height: 300px;
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

        .user-login::before {
            background-color: #4CAF50;
        }

        .checkin::before {
            background-color: #2196f3;
        }

        .button-icon {
            font-size: 60px;
            margin-bottom: 20px;
            color: #333;
        }

        .button-text {
            font-size: 24px;
            color: #333;
            font-weight: 500;
            margin-bottom: 15px;
        }

        .button-description {
            font-size: 16px;
            color: #666;
            max-width: 200px;
            line-height: 1.5;
        }

        @media (max-width: 768px) {
            .button-container {
                flex-direction: column;
                align-items: center;
            }

            .dashboard-button {
                width: 100%;
                max-width: 300px;
                height: 250px;
            }
        }
    </style>
</head>
<body>
    <header class="header">
        <h1>Hotel Management Admin Dashboard</h1>
        <a href="#" class="home-link">Home</a>
    </header>

    <div class="button-container">
        <!-- User Login Details Button -->
        <a href="userRgis">
        <button class="dashboard-button user-login">
            <div class="button-icon">👥</div>
            <div class="button-text">User Login Details</div>
            <div class="button-description">Track guest login information and monitor current user activities</div>
        </button>
        </a>

        <!-- Check-in Details Button -->
        <a href="user">
        <button class="dashboard-button checkin">
            <div class="button-icon">📝</div>
            <div class="button-text">Check-in Details</div>
            <div class="button-description">Manage guest check-ins, reservations and room assignments</div>
        </button>
        </a>
    </div>
</body>
</html>