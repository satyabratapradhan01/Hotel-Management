<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel Management System</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        body {
            background: linear-gradient(135deg, #1a237e, #0d47a1);
            min-height: 100vh;
        }
        
          a {
            text-decoration: none;
        }

        .header {
            background-color: white;
            padding: 1rem 2rem;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .header h1 {
            color: #333;
        }

        .nav-menu {
            display: flex;
            gap: 1rem;
        }

        .nav-menu a {
            color: #666;
            text-decoration: none;
            padding: 0.5rem 1rem;
            border-radius: 4px;
            transition: background-color 0.3s;
        }

        .nav-menu a:hover {
            background-color: #f0f0f0;
        }

        .stats-container {
            display: flex;
            justify-content: center;
            gap: 2rem;
            padding: 2rem;
            max-width: 1200px;
            margin: 2rem auto;
        }

        .stat-button {
            flex: 1;
            aspect-ratio: 2/1;
            max-width: 400px;
            border-radius: 12px;
            padding: 2rem;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            cursor: pointer;
            transition: transform 0.3s, box-shadow 0.3s;
            position: relative;
            overflow: hidden;
        }

        .stat-button::after {
            content: '';
            position: absolute;
            bottom: 0;
            right: 0;
            width: 30%;
            height: 30%;
            background: rgba(255, 255, 255, 0.1);
            border-radius: 50%;
            transform: translate(25%, 25%);
        }

        .login-details {
            background: #4CAF50;  /* Green */
            box-shadow: 0 8px 32px rgba(76, 175, 80, 0.3);
        }

        .checkin-details {
            background: #2196F3;  /* Blue */
            box-shadow: 0 8px 32px rgba(33, 150, 243, 0.3);
        }

        .stat-button:hover {
            transform: translateY(-5px);
            box-shadow: 0 12px 40px rgba(0,0,0,0.2);
        }

        .stat-number {
            font-size: 4rem;
            font-weight: bold;
            color: white;
            margin-bottom: 1rem;
            text-shadow: 2px 2px 4px rgba(0,0,0,0.2);
        }

        .stat-title {
            font-size: 1.5rem;
            color: white;
            text-align: center;
            text-shadow: 1px 1px 2px rgba(0,0,0,0.2);
        }

        .background-dots {
            position: absolute;
            width: 100%;
            height: 100%;
            background-image: radial-gradient(circle, rgba(255,255,255,0.1) 1px, transparent 1px);
            background-size: 20px 20px;
            opacity: 0.5;
        }

        @media (max-width: 768px) {
            .stats-container {
                flex-direction: column;
                align-items: center;
                padding: 1rem;
            }

            .stat-button {
                width: 100%;
            }

            .header {
                flex-direction: column;
                text-align: center;
                padding: 1rem;
            }

            .nav-menu {
                margin-top: 1rem;
                flex-wrap: wrap;
                justify-content: center;
            }
        }
    </style>
</head>
<body>
    <header class="header">
        <h1>Hotel Management Admin Dashboard</h1>
        <nav class="nav-menu">
            <a href="#">Home</a>
        </nav>
    </header>
<a href="userRgis">
    <div class="stats-container">
        <!-- User Login Details Button -->
        <div class="stat-button login-details">
            <div class="background-dots"></div>
            <div class="stat-number"></div>
            <div class="stat-title">User Login Details</div>
        </div>
</a>
        <!-- Check-in Details Button -->
        <a href="user">
        <div class="stat-button checkin-details">
            <div class="background-dots"></div>
            <div class="stat-number"></div>
            <div class="stat-title">Check-in Details</div>
        </div>
        </a>
    </div>
</body>
</html>