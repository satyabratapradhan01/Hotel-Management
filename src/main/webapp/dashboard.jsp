<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Search</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        nav {
            width: 100%;
            background-color: #1E90FF; /* Changed color to blue */
            padding: 10px 0;
            position: absolute;
            top: 0;
            display: flex;
            justify-content: center;
        }
        nav a {
            color: white;
            padding: 14px 20px;
            text-decoration: none;
            text-align: center;
            font-size: 18px;
        }
        nav a:hover {
            background-color: #4682B4; /* Lighter shade of blue for hover */
        }
        form {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            margin-top: 50px;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <!-- Navigation Bar -->
    <nav>
        <a class="nav-link" href="newhome.html">Home
           
        </a>
    </nav>

    <!-- Search Form -->
    <form action="Search" method="post">
        <h2>User Search</h2>
        <input type="text" name="username" placeholder="Enter your username">
        <input type="submit" value="Search">
    </form>

</body>
</html>
