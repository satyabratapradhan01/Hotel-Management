<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Entry Form</title>
    <style>
        <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            background-color: white;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }

        h1 {
            color: #1a73e8;
            text-align: center;
            margin-bottom: 2rem;
            font-size: 24px;
        }

        .form-group {
            margin-bottom: 1.5rem;
        }

        label {
            display: block;
            margin-bottom: 0.5rem;
            color: #5f6368;
            font-size: 14px;
        }

        input {
            width: 100%;
            padding: 0.75rem;
            border: 1px solid #dadce0;
            border-radius: 4px;
            font-size: 16px;
            transition: border-color 0.2s;
        }

        input:focus {
            outline: none;
            border-color: #1a73e8;
            box-shadow: 0 0 0 2px rgba(26, 115, 232, 0.2);
        }

        button {
            width: 100%;
            padding: 0.75rem;
            background-color: #1a73e8;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.2s;
        }

        button:hover {
            background-color: #1557b0;
        }

        .error {
            color: #d93025;
            font-size: 12px;
            margin-top: 0.25rem;
            display: none;
        }

        input:invalid:not(:placeholder-shown) {
            border-color: #d93025;
        }

        input:invalid:not(:placeholder-shown) + .error {
            display: block;
        }
    </style>
    </style>
</head>
<body>
    <div class="container">
        <h1>Admin Entry Form</h1>
        <form id="adminForm" action="register" method="post">
            <div class="form-group">
                <label for="adminName">Full Name</label>
                <input 
                    type="text" 
                    id="adminName" 
                    name="adminName" 
                    placeholder="Enter full name"
                    required
                    minlength="3"
                >
                <div class="error">Please enter a valid name (minimum 3 characters)</div>
            </div>

            <div class="form-group">
                <label for="adminUsername">Username</label>
                <input 
                    type="text" 
                    id="adminUsername" 
                    name="adminUsername" 
                    placeholder="Enter username" 
                >
            </div>

            <div class="form-group">
                <label for="adminPassword">Password</label>
                <input 
                    type="password" 
                    id="adminPassword" 
                    name="adminPassword" 
                    placeholder="Enter password"
                    
                >
                
            </div>

            <button type="submit">Create Admin Account</button>
        </form>
    </div>
</body>
</html>
